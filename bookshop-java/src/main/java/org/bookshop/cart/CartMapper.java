package org.bookshop.cart;

import org.bookshop.cart.infrastructure.CartEntity;
import org.bookshop.user.User;


public class CartMapper {

    public static Cart cartEntityToDomain(CartEntity cart, User user){
        return CartBuilder.builder()
                .withUser(user)
                .withItems(cart.getItems())
                .build();
    }

    public static CartEntity cartDomainToEntity(Cart cart){
        return new CartEntity(
                cart.getUser().getId(),
                cart.getItems());
    }
}
