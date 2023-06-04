package org.bookshop.cart.cartItem;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    private final CartItemProvider cartItemProvider;

    public CartItemService(CartItemProvider cartItemProvider) {
        this.cartItemProvider = cartItemProvider;
    }

    public CartItem getCartItemById(String cartId, String productId){
        return cartItemProvider.getCartItemById(cartId, productId);
    }

    public List<CartItem> getCartItemsByCartId(String cartId){
        return cartItemProvider.getCartItemsByCartId(cartId);
    }
    public void addItemToCart(CartItem cartItem){
        cartItemProvider.saveCartItem(cartItem);
    }

    public void editCartItem(CartItem cartItem){
        getCartItemById(cartItem.getCartId(), cartItem.getProduct().getId());
        cartItemProvider.saveCartItem(cartItem);
    }
}
