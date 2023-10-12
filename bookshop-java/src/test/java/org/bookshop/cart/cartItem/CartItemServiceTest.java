package org.bookshop.cart.cartItem;

import org.bookshop.cart.cartItem.infrastructure.CartItemEntity;
import org.bookshop.cart.cartItem.infrastructure.CartItemId;
import org.bookshop.exceptions.NotFoundException;
import org.bookshop.product.Product;
import org.bookshop.product.ProductService;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

class CartItemServiceTest {

    private CartItemService cartItemService;
    private CartItemProvider cartItemProvider;
    private CartItemRepository cartItemRepositoryMock;
    private ProductService productServiceMock;

    @BeforeEach
    void init(){
        cartItemRepositoryMock = mock(CartItemRepository.class);
        productServiceMock = mock(ProductService.class);
        cartItemProvider = new CartItemProvider(cartItemRepositoryMock, productServiceMock);
        cartItemService = new CartItemService(cartItemProvider);
    }

    @Test
    void getCartItemById() {
        //given
        CartItem cartItem = CartItemExample.getCartItem1();
        CartItemEntity cartItemEntity = CartItemMapper.cartItemDomainToEntity(cartItem);
        CartItemId cartItemId = new CartItemId(
                new ObjectId(cartItem.getCartId()),
                cartItem.getProduct().getId()
        );
        given(cartItemRepositoryMock.getCartItemById(cartItemId))
                .willReturn(Optional.of(cartItemEntity));
        given(productServiceMock.getProductById(cartItemId.getProductId()))
                .willReturn(cartItem.getProduct());
        //when
        var result = cartItemService.getCartItemById(
                cartItemId.getCartId().toString(),
                cartItemId.getProductId());
        //then
        then(cartItemRepositoryMock).should().getCartItemById(cartItemId);
        then(productServiceMock).should().getProductById(cartItemId.getProductId());
        assertThat(result).isEqualTo(cartItem);
    }

    @Test
    void getCartItemsByCartId() {
        //given
        List<CartItem> cartItems = CartItemExample.getCartItemList1();
        List<CartItemEntity> cartItemEntities = CartItemMapper.cartItemDomainsToEntities(cartItems);
        String cartId = cartItems.get(0).getCartId();
        Map<String, Product> productsFromItems = cartItems
                .stream()
                .collect(Collectors.toMap(
                        cartItem -> cartItem.getProduct().getId(),
                        CartItem::getProduct));
        given(productServiceMock.getProductsByIds(anyList()))
                .willReturn(productsFromItems);
        given(cartItemRepositoryMock.getCartItemsByCartId(cartId))
                .willReturn(cartItemEntities);
        //when
        var result = cartItemService.getCartItemsByCartId(cartId);
        //then
        then(cartItemRepositoryMock).should().getCartItemsByCartId(cartId);
        then(productServiceMock).should().getProductsByIds(anyList());
        assertThat(result).isEqualTo(cartItems);
    }

    @Test
    void addItemToCart() {
        //given
        CartItem cartItem = CartItemExample.getCartItem1();
        CartItemEntity cartItemEntity = CartItemMapper.cartItemDomainToEntity(cartItem);
        //when
        cartItemService.addItemToCart(cartItem);
        //then
        then(cartItemRepositoryMock).should().saveCartItem(cartItemEntity);
    }

    @Test
    void editCartItem() {
        //given
        CartItem cartItem = CartItemExample.getCartItem1();
        CartItemEntity cartItemEntity = CartItemMapper.cartItemDomainToEntity(cartItem);
        given(cartItemRepositoryMock.getCartItemById(cartItemEntity.getId()))
                .willReturn(Optional.of(cartItemEntity));
        given(productServiceMock.getProductById(cartItemEntity.getId().getProductId()))
                .willReturn(cartItem.getProduct());
        //when
        cartItemService.editCartItem(cartItem);
        //then
        then(cartItemRepositoryMock).should().saveCartItem(cartItemEntity);
        then(productServiceMock).should().getProductById(cartItemEntity.getId().getProductId());

    }

    @Test
    void editCartItem_CartItemDoesNotExist_ShouldThrowNotFoundException() {
        //given
        CartItem cartItem = CartItemExample.getCartItem1();
        CartItemEntity cartItemEntity = CartItemMapper.cartItemDomainToEntity(cartItem);
        given(cartItemRepositoryMock.getCartItemById(cartItemEntity.getId()))
                .willReturn(Optional.empty());
        //when
        var result = catchThrowable(() ->
                cartItemService.editCartItem(cartItem));
        //then
        then(cartItemRepositoryMock).should().getCartItemById(cartItemEntity.getId());
        assertThat(result).isInstanceOf(NotFoundException.class);
        assertThat(result).hasMessage(String.format("Cart item with id: %s not found", cartItemEntity.getId()));
    }
}