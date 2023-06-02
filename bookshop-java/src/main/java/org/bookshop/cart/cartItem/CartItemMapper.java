package org.bookshop.cart.cartItem;

import org.bookshop.cart.cartItem.infrastructure.CartItemEntity;
import org.bookshop.cart.cartItem.infrastructure.CartItemId;
import org.bookshop.cart.cartItem.infrastructure.CartItemWriteModel;
import org.bookshop.product.Product;
import org.bson.types.ObjectId;

public class CartItemMapper {
    public static CartItem cartItemEntityToDomain(CartItemEntity cartItemEntity, Product product){
        return CartItem.createCartItem(
                cartItemEntity.getId().getCartId().toString(),
                product,
                cartItemEntity.getQuantity());
    }

    public static CartItemEntity cartItemDomainToEntity(CartItem cartItem){
        return new CartItemEntity(
                new CartItemId(new ObjectId(cartItem.getCartId()), cartItem.getProduct().getId()),
                cartItem.getQuantity()
        );
    }

    public static CartItem cartItemWriteModelToDomain(CartItemWriteModel cartItemWriteModel, Product product){
        return CartItem.createCartItem(
                cartItemWriteModel.getCartId(),
                product,
                cartItemWriteModel.getQuantity());
    }
}
