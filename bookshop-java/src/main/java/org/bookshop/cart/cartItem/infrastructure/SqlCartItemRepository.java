package org.bookshop.cart.cartItem.infrastructure;

import org.bookshop.cart.cartItem.CartItemRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface SqlCartItemRepository extends CartItemRepository, MongoRepository<CartItemEntity, CartItemId> {

    List<CartItemEntity> findById_CartId(ObjectId cartId);

    @Override
    default List<CartItemEntity> getCartItemsByCartId(String cartId) {
        return this.findById_CartId(new ObjectId(cartId));
    }

    @Override
    default void saveCartItem(CartItemEntity cartItemEntity) {
        this.save(cartItemEntity);
    }
}
