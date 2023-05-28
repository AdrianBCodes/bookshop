package org.bookshop.configuration;

import org.bookshop.book.BookService;
import org.bookshop.book.infrastructure.SqlBookRepository;
import org.bookshop.cart.CartProvider;
import org.bookshop.cart.infrastructure.SqlCartRepository;
import org.bookshop.user.infrastructure.SqlUserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    BookService bookService(SqlBookRepository sqlBookRepository){
        return new BookService(sqlBookRepository);
    }

    @Bean
    CartProvider cartProvider(SqlCartRepository sqlCartRepository, SqlUserRepository userRepository){
        return new CartProvider(sqlCartRepository, userRepository);
    }
}
