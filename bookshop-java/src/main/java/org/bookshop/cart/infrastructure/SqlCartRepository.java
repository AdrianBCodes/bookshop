package org.bookshop.cart.infrastructure;

import org.bookshop.cart.CartRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SqlCartRepository extends CartRepository, MongoRepository<CartEntity, ObjectId> {
    Optional<CartEntity> findByUserId(ObjectId userId);
    @Override
    default Optional<CartEntity> getCartByUserId(ObjectId userId){
        return findByUserId(userId);
    }

    @Override
    default void saveCart(CartEntity cartEntity){
        this.save(cartEntity);
    }
}
