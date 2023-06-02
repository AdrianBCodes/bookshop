package org.bookshop.cart.cartItem.infrastructure;

public class CartItemWriteModel {
    private String cartId;
    private String productId;
    private int quantity;

    public CartItemWriteModel(){

    }

    public String getCartId() {
        return cartId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
