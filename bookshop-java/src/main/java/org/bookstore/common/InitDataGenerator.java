package org.bookstore.common;

import org.bookstore.book.Book;
import org.bookstore.book.BookBuilder;
import org.bookstore.book.BookCategory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class InitDataGenerator {
    public static List<Book> generateBooks(int number) {
        List<Book> books = new ArrayList<>();
        IntStream.rangeClosed(1, number)
                .forEach(i -> books.add(
                        BookBuilder.builder()
                                .withId((long) i)
                                .withName(String.format("Book%d", i))
                                .withDescription(String.format("Description%d", i))
                                .withPrice(BigDecimal.valueOf(i))
                                .withCategory(BookCategory.values()[i % BookCategory.values().length])
                                .buildWithId()));
        return books;
    }
}
