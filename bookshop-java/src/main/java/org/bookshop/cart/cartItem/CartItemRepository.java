package org.bookshop.cart.cartItem;

import org.bookshop.cart.cartItem.infrastructure.CartItemEntity;

import java.util.List;

public interface CartItemRepository {
    List<CartItemEntity> getCartItemsByCartId(String cartId);

    void saveCartItem(CartItemEntity cartItem);
}
