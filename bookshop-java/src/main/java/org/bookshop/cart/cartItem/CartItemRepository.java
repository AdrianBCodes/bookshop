package org.bookshop.cart.cartItem;

import org.bookshop.cart.cartItem.infrastructure.CartItemEntity;
import org.bookshop.cart.cartItem.infrastructure.CartItemId;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository {

    Optional<CartItemEntity> getCartItemById(CartItemId id);
    List<CartItemEntity> getCartItemsByCartId(String cartId);

    void saveCartItem(CartItemEntity cartItem);
}
