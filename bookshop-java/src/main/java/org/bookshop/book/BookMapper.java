package org.bookshop.book;

import org.bookshop.book.infrastructure.BookEntity;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class BookMapper {
    public static Book bookEntityToDomain(BookEntity bookEntity){
        return BookBuilder.builder()
                .withId(bookEntity.getId())
                .withName(bookEntity.getName())
                .withDescription(bookEntity.getDescription())
                .withCategory(bookEntity.getCategory())
                .withPrice(bookEntity.getPrice())
                .buildWithId();
    }

    public static BookEntity bookDomainToEntity(Book book){
        return new BookEntity(
                book.getId(),
                book.getName(),
                book.getDescription(),
                book.getCategory(),
                book.getPrice()
        );
    }

    public static List<BookEntity> booksDomainToEntity(List<Book> books){
        return books.stream().map(book -> new BookEntity(
                book.getId(),
                book.getName(),
                book.getDescription(),
                book.getCategory(),
                book.getPrice())
        ).collect(Collectors.toList());
    }

    public static Set<BookEntity> booksDomainToEntity(Set<Book> books){
        return books.stream().map(book -> new BookEntity(
                book.getId(),
                book.getName(),
                book.getDescription(),
                book.getCategory(),
                book.getPrice())
        ).collect(Collectors.toSet());
    }

}
