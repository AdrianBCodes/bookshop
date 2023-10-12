package org.bookshop.cart;

import org.bookshop.cart.cartItem.CartItem;
import org.bookshop.user.User;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;


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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cart cart = (Cart) o;
        return user.equals(cart.user) && Objects.equals(items, cart.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, items);
    }
    
    @Override
    public String toString() {
        return String.format("Cart{userId=%s, items=%s}",
                user.getId(),
                items);
}
