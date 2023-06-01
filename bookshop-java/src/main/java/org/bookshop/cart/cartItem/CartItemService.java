package org.bookshop.cart.cartItem;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    private final CartItemProvider cartItemProvider;

    public CartItemService(CartItemProvider cartItemProvider) {
        this.cartItemProvider = cartItemProvider;
    }

    public List<CartItem> getCartItemsByCartId(String cartId){
        return cartItemProvider.getCartItemsByCartId(cartId);
    }
}
