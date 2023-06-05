package org.bookshop.cart.infrastructure;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "carts")
public class CartEntity {
    private final ObjectId userId;

    public CartEntity(ObjectId userId) {
        this.userId = userId;
    }

    public ObjectId getUserId() {
        return userId;
    }
}
