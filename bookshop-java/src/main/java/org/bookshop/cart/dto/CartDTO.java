package org.bookshop.cart.dto;

import org.bookshop.cart.cartItem.CartItem;
import org.bson.types.ObjectId;

import java.util.List;

public class CartDTO {
    private ObjectId userId;
    private final List<CartItem> items;

    public CartDTO(ObjectId userId, List<CartItem> items) {
        this.userId = userId;
        this.items = items;
    }

    public ObjectId getUserId() {
        return userId;
    }

    public void setUserId(ObjectId userId) {
        this.userId = userId;
    }

    public List<CartItem> getItems() {
        return items;
    }
}
