package org.bookshop.book;

import org.bookshop.book.infrastructure.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface BookRepository {
    Optional<BookEntity> findBookById(String id);
    Map<String, BookEntity> findBooksByIds(List<String> ids);
    Page<BookEntity> findAllBooks(Pageable page);
    String saveBook(BookEntity entity);
    void saveAllBooks(List<BookEntity> entities);
}
