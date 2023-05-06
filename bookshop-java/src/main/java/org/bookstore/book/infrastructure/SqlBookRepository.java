package org.bookstore.book.infrastructure;

import org.bookstore.book.Book;
import org.bookstore.book.BookCategory;
import org.bookstore.book.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;


public interface SqlBookRepository extends BookRepository, JpaRepository<Book, Long> {

    Page<Book> findAllByPriceEquals(BigDecimal price, Pageable pageable);
    Page<Book> findAllByPriceGreaterThan(BigDecimal price,Pageable pageable);
    Page<Book> findAllByNameContaining(String name, Pageable pageable);
    Page<Book> findAllByCategory(BookCategory category, Pageable pageable);
    Page<Book> findAll(Pageable pageable);

    @Override
    default Optional<Book> findBookById(Long id){
        return this.findById(id);
    }

    @Override
    default Page<Book> findAllBooks(Pageable pageable) {
        return this.findAll(pageable);
    }

    @Override
    default Long saveBook(Book entity) {
        this.save(entity);
        return entity.getId();
    }

    @Override
    default void saveAllBooks(List<Book> entities){
        this.saveAll(entities);
    }
}
