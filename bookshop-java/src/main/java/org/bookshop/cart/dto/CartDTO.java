package org.bookshop.cart.dto;

import org.bookshop.cart.Cart;
import org.bookshop.cart.cartItem.dto.CartItemDTO;

import java.util.List;
import java.util.stream.Collectors;

public class CartDTO {
    private String userId;
    private final List<CartItemDTO> items;

    public CartDTO(String userId, List<CartItemDTO> items) {
        this.userId = userId;
        this.items = items;
    }

    public static CartDTO createCartDTO(Cart cart){
        return new CartDTO(
                cart.getUser().getId().toString(),
                cart.getItems().stream().map(CartItemDTO::createCartItemDTO).collect(Collectors.toList())
        );
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<CartItemDTO> getItems() {
        return items;
    }
}
