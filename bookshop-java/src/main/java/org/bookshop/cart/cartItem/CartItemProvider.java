package org.bookshop.cart.cartItem;

import org.bookshop.cart.cartItem.infrastructure.CartItemEntity;
import org.bookshop.cart.cartItem.infrastructure.CartItemId;
import org.bookshop.exceptions.NotFoundException;
import org.bookshop.product.Product;
import org.bookshop.product.ProductService;
import org.bson.types.ObjectId;

import java.util.List;
import java.util.Map;

public class CartItemProvider {

    private final CartItemRepository cartItemRepository;

    private final ProductService productService;

    public CartItemProvider(CartItemRepository cartItemRepository, ProductService productService) {
        this.cartItemRepository = cartItemRepository;
        this.productService = productService;
    }

    public CartItem getCartItemById(String cartId, String productId) {
        CartItemId cartItemId = new CartItemId(new ObjectId(cartId), productId);
        CartItemEntity cartItemEntity = cartItemRepository.getCartItemById(cartItemId)
                .orElseThrow(() ->
                        new NotFoundException(String.format("Cart item with id: %s not found", cartItemId))
                );
        Product product = productService.getProductById(cartItemEntity.getId().getProductId());
        return CartItemMapper.cartItemEntityToDomain(cartItemEntity, product);
    }

    List<CartItem> getCartItemsByCartId(String id) {
        List<CartItemEntity> items = cartItemRepository.getCartItemsByCartId(id);
        List<String> productsIds = items
                .stream()
                .map(item ->
                        item.getId().getProductId())
                .toList();
        Map<String, Product> productsFromItems = productService.getProductsByIds(productsIds);
        return CartItemMapper.cartItemEntitiesToDomains(items, productsFromItems);
    }

    public void saveCartItem(CartItem cartItem) {
        CartItemEntity toSave = CartItemMapper.cartItemDomainToEntity(cartItem);
        cartItemRepository.saveCartItem(toSave);
    }
}
