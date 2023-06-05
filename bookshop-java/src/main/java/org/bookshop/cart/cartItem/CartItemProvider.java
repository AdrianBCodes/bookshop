package org.bookshop.cart.cartItem;

import org.bookshop.cart.cartItem.infrastructure.CartItemEntity;
import org.bookshop.cart.cartItem.infrastructure.CartItemId;
import org.bookshop.exceptions.NotFoundException;
import org.bookshop.product.Product;
import org.bookshop.product.ProductService;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

public class CartItemProvider {

    private final CartItemRepository cartItemRepository;

    private final ProductService productService;

    private static final Logger logger = LoggerFactory.getLogger(CartItemProvider.class);


    public CartItemProvider(CartItemRepository cartItemRepository, ProductService productService) {
        this.cartItemRepository = cartItemRepository;
        this.productService = productService;
    }

    public CartItem getCartItemById(String cartId, String productId) {
        CartItemId cartItemId = new CartItemId(new ObjectId(cartId), productId);
        logger.info("Getting cart item by ID: cartId={}, productId={}", cartId, productId);
        CartItemEntity cartItemEntity = cartItemRepository.getCartItemById(cartItemId)
                .orElseThrow(() ->
                        new NotFoundException(String.format("Cart item with id: %s not found", cartItemId))
                );
        Product product = productService.getProductById(cartItemEntity.getId().getProductId());
        return CartItemMapper.cartItemEntityToDomain(cartItemEntity, product);
    }

    public List<CartItem> getCartItemsByCartId(String id) {
        logger.info("Getting cart items by cart ID: id={}", id);
        List<CartItemEntity> items = cartItemRepository.getCartItemsByCartId(id);
        List<String> productsIds = items
                .stream()
                .map(item -> item.getId().getProductId())
                .toList();
        Map<String, Product> productsFromItems = productService.getProductsByIds(productsIds);
        return CartItemMapper.cartItemEntitiesToDomains(items, productsFromItems);
    }

    public void saveCartItem(CartItem cartItem) {
        logger.info("Saving cart item: cartItem={}", cartItem);
        CartItemEntity toSave = CartItemMapper.cartItemDomainToEntity(cartItem);
        cartItemRepository.saveCartItem(toSave);
    }
}
