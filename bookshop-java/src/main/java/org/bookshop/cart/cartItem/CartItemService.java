package org.bookshop.cart.cartItem;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    private final CartItemProvider cartItemProvider;

    private static final Logger logger = LoggerFactory.getLogger(CartItemService.class);

    public CartItemService(CartItemProvider cartItemProvider) {
        this.cartItemProvider = cartItemProvider;
    }

    public CartItem getCartItemById(String cartId, String productId) {
        logger.info("Getting cart item by ID: cartId={}, productId={}", cartId, productId);
        return cartItemProvider.getCartItemById(cartId, productId);
    }

    public List<CartItem> getCartItemsByCartId(String cartId) {
        logger.info("Getting cart items by cart ID: cartId={}", cartId);
        return cartItemProvider.getCartItemsByCartId(cartId);
    }

    public void addItemToCart(CartItem cartItem) {
        logger.info("Adding item to cart: cartItem={}", cartItem);
        cartItemProvider.saveCartItem(cartItem);
    }

    public void editCartItem(CartItem cartItem) {
        CartItem toEdit = getCartItemById(cartItem.getCartId(), cartItem.getProduct().getId());
        logger.info("Editing cart item: from cartItem={} to cartItem={}", toEdit, cartItem);
        cartItemProvider.saveCartItem(cartItem);
    }
}
