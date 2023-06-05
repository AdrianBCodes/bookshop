package org.bookshop.cart;

import org.bookshop.cart.cartItem.CartItem;
import org.bookshop.user.User;

import java.util.List;

public class CartBuilder {

    private User user;
    private List<CartItem> items;

    public static CartBuilder builder(){
        return new CartBuilder();
    }
    public CartBuilder withUser(User userId){
        this.user = userId;
        return this;
    }

    public CartBuilder withItems(List<CartItem> items){
        this.items = items;
        return this;
    }

    public Cart build(){
        return new Cart(user, items);
    }
}
