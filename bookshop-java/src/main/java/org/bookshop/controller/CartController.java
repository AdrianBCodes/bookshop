package org.bookshop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bookshop.cart.Cart;
import org.bookshop.cart.CartService;
import org.bookshop.cart.dto.CartDTO;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cart")
@Api(value = "Carts API")
public class CartController {
    private final CartService cartService;
    private final Logger logger = LoggerFactory.getLogger(CartController.class);

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "Get Cart by User Id", response = Cart.class)
    public ResponseEntity<CartDTO> getCartByUserId(@PathVariable ObjectId userId){
        logger.info("Sent request to find cart by user with id: {}", userId.toString());
        CartDTO cart = cartService.getCartByUserId(userId).toDTO();
        logger.info("Returning cart: {}", cart);
        return ResponseEntity.ok(cart);
    }
}
