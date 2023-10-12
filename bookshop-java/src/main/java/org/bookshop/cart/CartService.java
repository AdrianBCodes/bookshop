package org.bookshop.cart;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class CartService {
    private final CartProvider cartProvider;

    private final Logger logger = LoggerFactory.getLogger(CartService.class);

    public CartService(CartProvider cartProvider) {
        this.cartProvider = cartProvider;
    }

    public Cart getCartByUserId(ObjectId userId){
        logger.info("Searching for cart with user id: {}", userId);
        return cartProvider.getCartByUserId(userId);
    }
}
