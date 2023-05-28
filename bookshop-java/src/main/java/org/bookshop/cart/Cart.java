package org.bookshop.cart;

import org.bookshop.cart.cartItem.CartItem;
import org.bookshop.cart.dto.CartDTO;
import org.bookshop.user.User;

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

    public CartDTO toDTO(){
        return new CartDTO(
                user.getId(),
                items
        );
    }

//    public void addItem(CartItem item) {
//        if(items.contains(item))
//            item.plusQuantity();
//        else
//            items.add(item);
//    }
//
//    public BigDecimal getTotalPrice(){
//        return items
//                .stream()
//                .map(CartItem::getTotalPrice)
//                .reduce(BigDecimal::add)
//                .orElse(BigDecimal.ZERO);
//    }
}
