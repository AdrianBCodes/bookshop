package org.bookstore.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> findBookById(Long id);
    Page<Book> findAllBooks(Pageable page);
    Page<Book> findAllFreeBooks(Pageable pageable);
    Page<Book> findAllPaidBooks(Pageable pageable);
    Page<Book> findAllByName(String name, Pageable pageable);
    Page<Book> findAllWithCategory(BookCategory category, Pageable pageable);
    Long saveBook(Book entity);
    void deleteBook(Book entity);
}
