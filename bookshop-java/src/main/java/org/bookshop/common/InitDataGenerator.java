package org.bookshop.common;

import org.bookshop.book.Book;
import org.bookshop.book.BookBuilder;
import org.bookshop.book.BookCategory;
import org.bookshop.book.BookMapper;
import org.bookshop.book.infrastructure.BookEntity;

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
                            .withId(String.format("Bk%d", i))
                            .withName(String.format("Book%d", i))
                            .withDescription(String.format("Description%d", i))
                            .withPrice(BigDecimal.valueOf(i))
                            .withCategory(BookCategory.values()[i % BookCategory.values().length])
                            .buildWithId()));

        return books;
    }

    public static List<BookEntity> generateBooksEntities(int number) {
        return new ArrayList<>(BookMapper.booksDomainToEntity(generateBooks(number)));
    }
}
