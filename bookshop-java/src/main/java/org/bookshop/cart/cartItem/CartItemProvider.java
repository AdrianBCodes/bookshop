package org.bookshop.cart.cartItem;

import org.bookshop.cart.cartItem.infrastructure.CartItemEntity;
import org.bookshop.product.Product;
import org.bookshop.product.ProductService;

import java.util.List;
import java.util.Map;

public class CartItemProvider {

    private final CartItemRepository cartItemRepository;

    private final ProductService productService;

    public CartItemProvider(CartItemRepository cartItemRepository, ProductService productService) {
        this.cartItemRepository = cartItemRepository;
        this.productService = productService;
    }

    List<CartItem> getCartItemsByCartId(String id){
        List<CartItemEntity> items = cartItemRepository.getCartItemsByCartId(id);
        List<String> productsIds = items
                .stream()
                .map(item ->
                        item.getId().getProductId())
                .toList();
        Map<String, Product> productsFromItems = productService.getProductsByIds(productsIds);
        return CartItemMapper.cartItemEntitiesToDomains(items, productsFromItems);
    }

    public void addItemToCart(CartItem cartItem) {
        CartItemEntity toSave = CartItemMapper.cartItemDomainToEntity(cartItem);
        cartItemRepository.saveCartItem(toSave);
    }
}
