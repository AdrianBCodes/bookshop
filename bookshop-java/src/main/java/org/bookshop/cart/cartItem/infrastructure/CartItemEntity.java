package org.bookshop.cart.cartItem.infrastructure;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItemEntity that = (CartItemEntity) o;
        return quantity == that.quantity && id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, quantity);
    }
}
