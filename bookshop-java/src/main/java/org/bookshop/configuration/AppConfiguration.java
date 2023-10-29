package org.bookshop.configuration;

import org.bookshop.book.BookProvider;
import org.bookshop.book.infrastructure.SqlBookRepository;
import org.bookshop.cart.CartProvider;
import org.bookshop.cart.cartItem.CartItemProvider;
import org.bookshop.cart.cartItem.CartItemService;
import org.bookshop.cart.cartItem.infrastructure.SqlCartItemRepository;
import org.bookshop.cart.infrastructure.SqlCartRepository;
import org.bookshop.product.ProductService;
import org.bookshop.user.infrastructure.SqlUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    BookProvider bookProvider(SqlBookRepository sqlBookRepository){
        return new BookProvider(sqlBookRepository);
    }

    @Bean
    CartProvider cartProvider(SqlCartRepository sqlCartRepository, SqlUserRepository userRepository, CartItemService cartItemService){
        return new CartProvider(sqlCartRepository, userRepository, cartItemService);
    }

    @Bean
    CartItemProvider cartItemProvider(SqlCartItemRepository sqlCartItemRepository, ProductService productService){
        return new CartItemProvider(sqlCartItemRepository, productService);
    }
}
