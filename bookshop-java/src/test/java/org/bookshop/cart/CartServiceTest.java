package org.bookshop.cart;

import org.bookshop.cart.cartItem.CartItemService;
import org.bookshop.cart.infrastructure.CartEntity;
import org.bookshop.exceptions.NotFoundException;
import org.bookshop.user.UserRepository;
import org.bson.types.ObjectId;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

class CartServiceTest {

    private CartProvider cartProvider;
    private CartRepository cartRepositoryMock;
    private UserRepository userRepositoryMock;
    private CartItemService cartItemService;
    private CartService cartService;

    @BeforeEach
    void init(){
        MockitoAnnotations.openMocks(this);
        cartRepositoryMock = mock(CartRepository.class);
        userRepositoryMock = mock(UserRepository.class);
        cartItemService = mock(CartItemService.class);
        cartProvider = new CartProvider(cartRepositoryMock, userRepositoryMock, cartItemService);
        cartService = new CartService(cartProvider);
    }

    @Test
    void getCartByUserId() {
        //given
        Cart cart = CartExample.getCart1();
        CartEntity cartEntity = CartMapper.cartDomainToEntity(cart);
        ObjectId cartUserId = cart.getUser().getId();
        given(cartRepositoryMock.getCartByUserId(cartUserId))
                .willReturn(Optional.of(cartEntity));
        given(userRepositoryMock.getUserById(cartUserId))
                .willReturn(Optional.ofNullable(cart.getUser()));
        given(cartItemService.getCartItemsByCartId(cartUserId.toString()))
                .willReturn(cart.getItems());
        //when
        var result = cartService.getCartByUserId(cartUserId);
        //then
        then(cartRepositoryMock).should().getCartByUserId(cartUserId);
        then(userRepositoryMock).should().getUserById(cartUserId);
        then(cartItemService).should().getCartItemsByCartId(cartUserId.toString());
        assertThat(result)
                .isEqualTo(cart);
    }

    @Test
    void getCartByUserId_CartWithoutItems() {
        //given
        Cart cart = CartExample.getCart2_EmptyItemList();
        CartEntity cartEntity = CartMapper.cartDomainToEntity(cart);
        ObjectId cartUserId = cart.getUser().getId();
        given(cartRepositoryMock.getCartByUserId(cartUserId))
                .willReturn(Optional.of(cartEntity));
        given(userRepositoryMock.getUserById(cartUserId))
                .willReturn(Optional.ofNullable(cart.getUser()));
        given(cartItemService.getCartItemsByCartId(cartUserId.toString()))
                .willReturn(cart.getItems());
        //when
        var result = cartService.getCartByUserId(cartUserId);
        //then
        then(cartRepositoryMock).should().getCartByUserId(cartUserId);
        then(userRepositoryMock).should().getUserById(cartUserId);
        then(cartItemService).should().getCartItemsByCartId(cartUserId.toString());
        assertThat(result)
                .isEqualTo(cart);
    }

    @Test
    void getCartByUserId_CartDoesNotExist_ShouldThrowNotFoundException() {
        //given
        Cart cart = CartExample.getCart1();
        ObjectId cartUserId = cart.getUser().getId();
        given(cartRepositoryMock.getCartByUserId(cartUserId))
                .willReturn(Optional.empty());
        //when
        var result = catchThrowable(() ->
                cartService.getCartByUserId(cartUserId)) ;
        //then
        then(cartRepositoryMock).should().getCartByUserId(cartUserId);
        assertThat(result)
                .isInstanceOf(NotFoundException.class)
                .hasMessage(String.format("Cart for User with id: %s not found", cart.getUser().getId()));
    }

    @Test
    void getCartByUserId_UserDoesNotExist_ShouldThrowNotFoundException() {
        //given
        Cart cart = CartExample.getCart1();
        CartEntity cartEntity = CartMapper.cartDomainToEntity(cart);
        ObjectId cartUserId = cart.getUser().getId();
        given(cartRepositoryMock.getCartByUserId(cartUserId))
                .willReturn(Optional.of(cartEntity));
        given(userRepositoryMock.getUserById(cartUserId))
                .willReturn(Optional.empty());
        //when
        var result = catchThrowable(() ->
                cartService.getCartByUserId(cartUserId)) ;
        //then
        then(cartRepositoryMock).should().getCartByUserId(cartUserId);
        then(userRepositoryMock).should().getUserById(cartUserId);
        assertThat(result)
                .isInstanceOf(NotFoundException.class)
                .hasMessage(String.format("User with id: %s not found", cart.getUser().getId()));
    }
}