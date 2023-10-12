package org.bookshop.cart;

import org.bookshop.cart.cartItem.CartItem;
import org.bookshop.cart.infrastructure.CartEntity;
import org.bookshop.user.User;

import java.util.List;


public class CartMapper {

    public static Cart cartEntityToDomain(User user, List<CartItem> cartItemList){
        return CartBuilder.builder()
                .withUser(user)
                .withItems(cartItemList)
                .build();
    }

    public static CartEntity cartDomainToEntity(Cart cart){
        return new CartEntity(
                cart.getUser().getId());
    }
}
