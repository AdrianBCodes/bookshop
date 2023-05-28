package org.bookshop.cart;

import org.bookshop.cart.infrastructure.CartEntity;
import org.bson.types.ObjectId;

import java.util.Optional;

public interface CartRepository {
    Optional<CartEntity> getCartByUserId(ObjectId userId);
    void saveCart(CartEntity cartEntity);
}
