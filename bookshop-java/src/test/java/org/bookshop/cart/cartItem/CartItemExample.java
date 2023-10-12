package org.bookshop.cart.cartItem;

import book.BookExample;

import java.util.List;

public class CartItemExample {
    public static CartItem getCartItem1(){
        return CartItem.createCartItem(
                "000000000000000000000001",
                BookExample.getBook1(),
                1);
    }
    public static CartItem getCartItem2(){
        return CartItem.createCartItem(
                "000000000000000000000001",
                BookExample.getBook2(),
                2);
    }

    public static List<CartItem> getCartItemList1(){
        return List.of(getCartItem1(), getCartItem2());
    }
}
