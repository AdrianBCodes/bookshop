package org.bookshop.cart.cartItem.infrastructure;

import org.bookshop.cart.cartItem.CartItemRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SqlCartItemRepository extends CartItemRepository, MongoRepository<CartItemEntity, ObjectId> {

    List<CartItemEntity> findByCartId(ObjectId cartId);

    @Override
    default List<CartItemEntity> getCartItemsByCartIt(String cartId) {
        return this.findByCartId(new ObjectId(cartId));
    }
}
