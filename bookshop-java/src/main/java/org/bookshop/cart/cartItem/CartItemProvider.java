package org.bookshop.cart.cartItem;

import org.bookshop.product.Product;
import org.bookshop.product.ProductService;

import java.util.List;

public class CartItemProvider {

    private final CartItemRepository cartItemRepository;

    private final ProductService productService;

    public CartItemProvider(CartItemRepository cartItemRepository, ProductService productService) {
        this.cartItemRepository = cartItemRepository;
        this.productService = productService;
    }

    List<CartItem> getCartItemsByCartId(String id){
        return cartItemRepository.getCartItemsByCartIt(id)
                .stream().map(cartItemEntity -> {
                    Product product = productService.getProductById(cartItemEntity.getProductId());
                    return CartItemMapper.cartItemEntityToDomain(cartItemEntity, product);
                }).toList();
    }
}
