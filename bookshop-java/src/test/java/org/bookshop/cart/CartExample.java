package org.bookshop.cart;

import org.bookshop.cart.cartItem.CartItemExample;
import org.bookshop.user.User;
import org.bson.types.ObjectId;

import java.util.ArrayList;

public class CartExample {

    public static Cart getCart1(){
        return CartBuilder.builder()
                .withUser(new User(new ObjectId("000000000000000000000001")))
                .withItems(CartItemExample.getCartItemList1())
                .build();
    }

    public static Cart getCart2_EmptyItemList(){
        return CartBuilder.builder()
                .withUser(new User(new ObjectId("000000000000000000000001")))
                .withItems(new ArrayList<>())
                .build();
    }
}
