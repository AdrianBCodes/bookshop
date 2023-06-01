package org.bookshop.cart.cartItem.infrastructure;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cartItems")
public class CartItemEntity {
    private final ObjectId id;
    private final ObjectId cartId;
    private final String productId;
    private final int quantity;

    public CartItemEntity(ObjectId id, ObjectId cartId, String productId, int quantity) {
        this.id = id;
        this.cartId = cartId;
        this.productId = productId;
        this.quantity = quantity;
    }

    public ObjectId getId() {
        return id;
    }

    public ObjectId getCartId() {
        return cartId;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }
}
