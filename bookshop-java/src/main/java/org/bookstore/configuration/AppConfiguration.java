package org.bookstore.configuration;

import org.bookstore.book.BookService;
import org.bookstore.book.infrastructure.SqlBookRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    BookService bookService(SqlBookRepository sqlBookRepository){
        return new BookService(sqlBookRepository);
    }
}
