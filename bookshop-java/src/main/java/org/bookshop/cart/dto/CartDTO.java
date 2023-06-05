package org.bookshop.cart.dto;

import org.bookshop.cart.Cart;
import org.bookshop.cart.cartItem.dto.CartItemDTO;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

public class CartDTO {
    private String userId;
    private final List<CartItemDTO> items;
    private BigDecimal totalPrice;

    public CartDTO(String userId, List<CartItemDTO> items, BigDecimal totalPrice) {
        this.userId = userId;
        this.items = items;
        this.totalPrice = totalPrice;
    }

    public static CartDTO createCartDTO(Cart cart){
        return new CartDTO(
                cart.getUser().getId().toString(),
                cart.getItems()
                        .stream()
                        .map(CartItemDTO::createCartItemDTO)
                        .collect(Collectors.toList()),
                cart.getTotalPrice());
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

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return String.format("CartDTO{userId='%s', items=%s, totalPrice=%s}",
                userId,
                items,
                totalPrice);
    }
}
