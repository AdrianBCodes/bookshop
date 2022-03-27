package org.bookstore.book.infrastructure;

import org.bookstore.book.Book;
import org.bookstore.book.BookCategory;
import org.bookstore.book.BookRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public interface SqlBookRepository extends BookRepository, JpaRepository<Book, Long> {

    List<Book> findAllByPriceEquals(BigDecimal price);
    List<Book> findAllByPriceGreaterThan(BigDecimal price);
    List<Book> findAllByNameContaining(String name);
    List<Book> findAllByCategory(BookCategory category);


    @Override
    default Optional<Book> findBookById(Long id){
        return this.findById(id);
    }

    @Override
    default List<Book> findAllBooks() {
        return this.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }

    @Override
    default List<Book> findAllFreeBooks() {
        return this.findAllByPriceEquals(BigDecimal.ZERO);
    }

    @Override
    default List<Book> findAllPaidBooks() {
        return this.findAllByPriceGreaterThan(BigDecimal.ZERO);
    }

    @Override
    default List<Book> findAllByName(String name) {
        return this.findAllByNameContaining(name);
    }

    @Override
    default List<Book> findAllWithCategory(BookCategory category) {
        return this.findAllByCategory(category);
    }

    @Override
    default Long saveBook(Book entity) {
        this.save(entity);
        return entity.getId();
    }

    @Override
    default void deleteBook(Book entity) {
        this.delete(entity);
    }
}
