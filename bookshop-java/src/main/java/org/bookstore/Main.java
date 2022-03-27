package org.bookstore;

import org.bookstore.book.Book;
import org.bookstore.book.BookCategory;
import org.bookstore.book.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.math.BigDecimal;

@SpringBootApplication()
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    // For presentation
    @Bean
    CommandLineRunner run(BookService bookService){
        return args -> {
          bookService.addBook(new Book("book1", "1st book for example", BookCategory.HORROR, BigDecimal.ONE ));
          bookService.addBook(new Book("book2", "2nd book for example", BookCategory.DRAMA, BigDecimal.TEN ));
          bookService.addBook(new Book("book3", "3rd book for example", BookCategory.THRILLER, BigDecimal.ZERO ));
        };
    }
}
