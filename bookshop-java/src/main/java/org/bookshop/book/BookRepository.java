package org.bookshop.book;

import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> findBookById(ObjectId id);
    Page<Book> findAllBooks(Pageable page);
    ObjectId saveBook(Book entity);
    void saveAllBooks(List<Book> entities);
}
