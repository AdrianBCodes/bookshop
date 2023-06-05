package org.bookshop.cart.cartItem.dto;

import org.bookshop.cart.cartItem.CartItem;
import org.bookshop.product.Product;

import java.math.BigDecimal;

public class CartItemDTO {
    private String cartId;
    private Product product;
    private int quantity;
    private BigDecimal totalPrice;

    public CartItemDTO() {
    }

    private CartItemDTO(String cartId, Product product, int quantity, BigDecimal totalPrice) {
        this.cartId = cartId;
        this.product = product;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public static CartItemDTO createCartItemDTO(CartItem cartItem){
        return new CartItemDTO(
                cartItem.getCartId(),
                cartItem.getProduct(),
                cartItem.getQuantity(),
                cartItem.getProduct()
                        .getPrice()
                        .multiply(BigDecimal.valueOf(cartItem.getQuantity()))
        );
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
