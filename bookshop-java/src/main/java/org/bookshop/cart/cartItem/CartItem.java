package org.bookshop.cart.cartItem;

import org.bookshop.product.Product;

import java.math.BigDecimal;
import java.util.Objects;

public class CartItem {
    private final String id;
    private final String cartId;
    private final Product product;
    private int quantity;

    private CartItem(String id, String cartId, Product product, int quantity) {
        this.id = id;
        this.cartId = cartId;
        this.product = product;
        this.quantity = quantity;
    }

    public static CartItem createCartItem(String id, String cartId, Product product, int quantity){
        Objects.requireNonNull(id);
        Objects.requireNonNull(cartId);
        Objects.requireNonNull(product);
        if(quantity < 1)
            throw new IllegalArgumentException("Quantity cannot be less than 1");
        return new CartItem(id, cartId, product, quantity);
    }

    public String getId() {
        return id;
    }

    public String getCartId() {
        return cartId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        if(quantity < 1)
            throw new IllegalArgumentException("Quantity cannot be less than 1");
        this.quantity = quantity;
    }

    public void plusQuantity(){
        quantity += 1;
    }

    public void minusQuantity(){
        if(quantity <= 1)
            return;
        quantity -= 1;
    }

    public BigDecimal getTotalPrice(){
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }
}
