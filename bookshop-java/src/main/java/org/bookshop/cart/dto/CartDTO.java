package org.bookshop.cart.dto;

import org.bookshop.cart.Cart;
import org.bookshop.cart.cartItem.CartItem;

import java.util.List;

public class CartDTO {
    private String userId;
    private final List<CartItem> items;

    public CartDTO(String userId, List<CartItem> items) {
        this.userId = userId;
        this.items = items;
    }

    public static CartDTO createCartDTO(Cart cart){
        return new CartDTO(
                cart.getUser().getId().toString(),
                cart.getItems()
        );
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<CartItem> getItems() {
        return items;
    }
}
