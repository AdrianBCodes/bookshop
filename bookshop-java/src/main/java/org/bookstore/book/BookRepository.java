package org.bookstore.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BookRepository {
    Optional<Book> findBookById(Long id);
    Page<Book> findAllBooks(Pageable page);
    Long saveBook(Book entity);
}
