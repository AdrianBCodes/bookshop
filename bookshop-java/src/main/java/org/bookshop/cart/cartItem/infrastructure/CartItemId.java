package org.bookshop.cart.cartItem.infrastructure;

import org.bson.types.ObjectId;

import java.util.Objects;

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
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemId that = (CartItemId) o;
        return cartId.equals(that.cartId) && productId.equals(that.productId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartId, productId);
    }
}
