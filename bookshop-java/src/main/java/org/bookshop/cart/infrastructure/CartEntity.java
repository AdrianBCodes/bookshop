package org.bookshop.cart.infrastructure;

import org.bookshop.cart.cartItem.CartItem;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "carts")
public class CartEntity {
    private final ObjectId userId;
    private final List<CartItem> items;

    public CartEntity(ObjectId userId, List<CartItem> items) {
        this.userId = userId;
        this.items = items;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public List<CartItem> getItems() {
        return items;
    }
}
