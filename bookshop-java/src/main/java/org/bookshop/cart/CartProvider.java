package org.bookshop.cart;

import org.bookshop.cart.infrastructure.CartEntity;
import org.bookshop.exceptions.NotFoundException;
import org.bookshop.user.User;
import org.bookshop.user.UserRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CartProvider {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(CartProvider.class);

    public CartProvider(CartRepository cartRepository, UserRepository userRepository) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
    }

    public Cart getCartByUserId(ObjectId userId){
        CartEntity cartEntity = cartRepository.getCartByUserId(userId)
                .orElseThrow(() -> {
                    logger.error(String.format("Cart for User with id %s not found", userId.toString()));
                    return new NotFoundException(String.format("Cart for User with id %s not found", userId));
                });
        User user = userRepository.getUserById(userId)
                .orElseThrow(() -> {
                    logger.error(String.format("User with id: %s not found", userId.toString()));
                    return new NotFoundException(String.format("User with id: %s not found", userId));
                });
        return CartMapper.cartEntityToDomain(cartEntity, user);
    }
}
