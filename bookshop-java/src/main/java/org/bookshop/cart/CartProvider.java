package org.bookshop.cart;

import org.bookshop.cart.cartItem.CartItem;
import org.bookshop.cart.cartItem.CartItemService;
import org.bookshop.exceptions.NotFoundException;
import org.bookshop.user.User;
import org.bookshop.user.UserRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class CartProvider {
    private final CartRepository cartRepository;
    private final UserRepository userRepository;

    private final CartItemService cartItemService;
    private final Logger logger = LoggerFactory.getLogger(CartProvider.class);

    public CartProvider(CartRepository cartRepository, UserRepository userRepository, CartItemService cartItemService) {
        this.cartRepository = cartRepository;
        this.userRepository = userRepository;
        this.cartItemService = cartItemService;
    }

    public Cart getCartByUserId(ObjectId userId){
        User user = userRepository.getUserById(userId)
                .orElseThrow(() -> {
                    logger.error(String.format("User with id: %s not found", userId.toString()));
                    return new NotFoundException(String.format("User with id: %s not found", userId));
                });
        List<CartItem> cartItemList = cartItemService.getCartItemsByCartId(userId.toString());
        return CartMapper.cartEntityToDomain(user, cartItemList);
    }
}
