package org.bookshop.cart;

import org.bookshop.cart.cartItem.CartItem;
import org.bookshop.user.User;

import java.math.BigDecimal;
import java.util.List;


public class Cart {
    private final User user;
    private final List<CartItem> items;

    public Cart(User user, List<CartItem> items) {
        this.user = user;
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public List<CartItem> getItems() {
        return items;
    }


    public void addItem(CartItem item) {
        if(items.contains(item))
            return;
        items.add(item);
    }

    public void removeItem(CartItem item) {
        if(!items.contains(item))
            throw new IllegalArgumentException("Cannot remove item. It is not in Cart.");
        items.remove(item);
    }

    public BigDecimal getTotalPrice() {
        return items
                .stream()
                .map(CartItem::getTotalPrice)
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO);
    }
}
