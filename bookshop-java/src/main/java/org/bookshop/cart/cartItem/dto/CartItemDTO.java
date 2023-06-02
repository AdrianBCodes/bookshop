package org.bookshop.cart.cartItem.dto;

import org.bookshop.cart.cartItem.CartItem;
import org.bookshop.product.Product;

public class CartItemDTO {
    private String cartId;
    private Product product;
    private int quantity;

    public CartItemDTO() {
    }

    public CartItemDTO(String cartId, Product product, int quantity) {
        this.cartId = cartId;
        this.product = product;
        this.quantity = quantity;
    }

    public static CartItemDTO createCartItemDTO(CartItem cartItem){
        return new CartItemDTO(
                cartItem.getCartId(),
                cartItem.getProduct(),
                cartItem.getQuantity());
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
}
