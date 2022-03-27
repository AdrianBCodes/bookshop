package org.bookstore.book;

import java.util.List;
import java.util.Optional;

public interface BookRepository {
    Optional<Book> findBookById(Long id);
    List<Book> findAllBooks();
    List<Book> findAllFreeBooks();
    List<Book> findAllPaidBooks();
    List<Book> findAllByName(String name);
    List<Book> findAllWithCategory(BookCategory category);
    Long saveBook(Book entity);
    void deleteBook(Book entity);
}
