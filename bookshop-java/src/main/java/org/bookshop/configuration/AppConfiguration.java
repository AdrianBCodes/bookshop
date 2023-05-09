package org.bookshop.configuration;

import org.bookshop.book.BookService;
import org.bookshop.book.infrastructure.SqlBookRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {
    @Bean
    BookService bookService(SqlBookRepository sqlBookRepository){
        return new BookService(sqlBookRepository);
    }
}
