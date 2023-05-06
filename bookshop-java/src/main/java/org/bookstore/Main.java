package org.bookstore;

import org.bookstore.book.BookRepository;
import org.bookstore.common.InitDataGenerator;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication()
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    CommandLineRunner run(BookRepository bookRepository){
        return args -> {
            bookRepository.saveAllBooks(InitDataGenerator.generateBooks(15));
        };
    }
}
