package org.bookshop.cart.cartItem;

import org.bookshop.cart.cartItem.infrastructure.CartItemEntity;
import org.bookshop.product.Product;
import org.bson.types.ObjectId;

public class CartItemMapper {
    public static CartItem cartItemEntityToDomain(CartItemEntity cartItemEntity, Product product){
        return CartItem.createCartItem(
                cartItemEntity.getId().toString(),
                cartItemEntity.getCartId().toString(),
                product,
                cartItemEntity.getQuantity());
    }

    public static CartItemEntity cartItemDomainToEntity(CartItem cartItem){
        return new CartItemEntity(
                new ObjectId(cartItem.getId()),
                new ObjectId(cartItem.getCartId()),
                cartItem.getProduct().getId(),
                cartItem.getQuantity()
        );
    }
}
