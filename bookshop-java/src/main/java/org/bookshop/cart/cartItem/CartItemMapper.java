package org.bookshop.cart.cartItem;

import org.bookshop.cart.cartItem.infrastructure.CartItemEntity;
import org.bookshop.cart.cartItem.infrastructure.CartItemId;
import org.bookshop.cart.cartItem.infrastructure.CartItemWriteModel;
import org.bookshop.product.Product;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

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

    public static List<CartItem> cartItemEntitiesToDomains(List<CartItemEntity> cartItemEntityList, Map<String, Product> productMap){
        return cartItemEntityList.stream()
                .map(cartItemEntity ->
                cartItemEntityToDomain(
                        cartItemEntity,
                        productMap.get(cartItemEntity.getId().getProductId()))
                ).toList();
    }

    public static List<CartItemEntity> cartItemDomainsToEntities(List<CartItem> cartItemList){
        return cartItemList.stream()
                .map(CartItemMapper::cartItemDomainToEntity)
                .toList();
    }
}
