package org.bookshop.cart.cartItem.infrastructure;

import org.bson.types.ObjectId;

public class CartItemId {
    private final ObjectId cartId;
    private final String productId;

    public CartItemId(ObjectId cartId, String productId) {
        this.cartId = cartId;
        this.productId = productId;
    }

    public ObjectId getCartId() {
        return cartId;
    }

    public String getProductId() {
        return productId;
    }
}
