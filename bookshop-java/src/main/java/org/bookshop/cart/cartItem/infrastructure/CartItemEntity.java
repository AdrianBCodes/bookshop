package org.bookshop.cart.cartItem.infrastructure;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

@Document(collection = "cartItems")
public class CartItemEntity {
    @MongoId
    private final CartItemId id;
    private final int quantity;

    public CartItemEntity(CartItemId id, int quantity) {
        this.id = id;
        this.quantity = quantity;
    }

    public CartItemId getId() {
        return id;
    }

    public int getQuantity() {
        return quantity;
    }
}
