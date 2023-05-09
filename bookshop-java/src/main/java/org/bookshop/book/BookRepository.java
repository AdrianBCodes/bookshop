package org.bookshop.book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> findBookById(Long id);
    Page<Book> findAllBooks(Pageable page);
    String saveBook(Book entity);
    void saveAllBooks(List<Book> entities);
}
