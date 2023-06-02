package org.bookshop.cart.cartItem;

import org.bookshop.cart.cartItem.infrastructure.CartItemEntity;
import org.bookshop.product.Product;
import org.bookshop.product.ProductService;

import java.util.List;

public class CartItemProvider {

    private final CartItemRepository cartItemRepository;

    private final ProductService productService;

    public CartItemProvider(CartItemRepository cartItemRepository, ProductService productService) {
        this.cartItemRepository = cartItemRepository;
        this.productService = productService;
    }

    List<CartItem> getCartItemsByCartId(String id){
        return cartItemRepository.getCartItemsByCartId(id)
                .stream().map(cartItemEntity -> {
                    Product product = productService.getProductById(cartItemEntity.getId().getProductId());
                    return CartItemMapper.cartItemEntityToDomain(cartItemEntity, product);
                }).toList();
    }

    public void addItemToCart(CartItem cartItem) {
        CartItemEntity toSave = CartItemMapper.cartItemDomainToEntity(cartItem);
        cartItemRepository.saveCartItem(toSave);
    }
}
