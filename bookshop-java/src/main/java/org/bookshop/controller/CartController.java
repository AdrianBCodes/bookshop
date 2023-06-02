package org.bookshop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bookshop.cart.CartService;
import org.bookshop.cart.cartItem.CartItem;
import org.bookshop.cart.cartItem.CartItemMapper;
import org.bookshop.cart.cartItem.CartItemService;
import org.bookshop.cart.cartItem.infrastructure.CartItemWriteModel;
import org.bookshop.cart.dto.CartDTO;
import org.bookshop.product.Product;
import org.bookshop.product.ProductService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/cart")
@Api(value = "Carts API")
public class CartController {
    private final CartService cartService;
    private final CartItemService cartItemService;
    private final ProductService productService;
    private final Logger logger = LoggerFactory.getLogger(CartController.class);

    public CartController(CartService cartService, CartItemService cartItemService, ProductService productService) {
        this.cartService = cartService;
        this.cartItemService = cartItemService;
        this.productService = productService;
    }

    @GetMapping("/{userId}")
    @ApiOperation(value = "Get Cart by User Id", response = CartDTO.class)
    public ResponseEntity<CartDTO> getCartByUserId(@PathVariable ObjectId userId){
        logger.info("Sent request to find cart by user with id: {}", userId.toString());
        CartDTO cart = CartDTO.createCartDTO(cartService.getCartByUserId(userId));
        logger.info("Returning cart: {}", cart);
        return ResponseEntity.ok(cart);
    }

    @PutMapping("")
    @ApiOperation(value = "Add CartItem to Cart")
    public ResponseEntity<?> addItemToCart(@RequestBody CartItemWriteModel cartItemWM){
        logger.info("Sent request to add cartItem to cart with User Id: {}", cartItemWM.getCartId());
        Product product = productService.getProductById(cartItemWM.getProductId());
        CartItem cartItem = CartItemMapper.cartItemWriteModelToDomain(cartItemWM, product);
        cartItemService.addItemToCart(cartItem);
        return ResponseEntity.noContent().build();
    }
}
