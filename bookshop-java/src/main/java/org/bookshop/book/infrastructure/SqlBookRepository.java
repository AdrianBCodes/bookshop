package org.bookshop.book.infrastructure;

import com.mongodb.lang.NonNull;
import org.bookshop.book.Book;
import org.bookshop.book.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


public interface SqlBookRepository extends BookRepository, MongoRepository<Book, String> {
    @NonNull
    Page<Book> findAll(@NonNull Pageable pageable);

    Set<Book> findBooksByIdIn(List<String> ids);

    @Override
    default Optional<Book> findBookById(String id){
        return this.findById(id);
    }

    @Override
    default Map<String, Book> findBooksByIds(List<String> ids) {
        return this.findBooksByIdIn(ids).stream()
                .collect(Collectors.toMap(
                        Book::getId,
                        book -> book
        ));
    }

    @Override
    default Page<Book> findAllBooks(Pageable pageable) {
        return this.findAll(pageable);
    }

    @Override
    default String saveBook(Book entity) {
        this.save(entity);
        return entity.getId();
    }

    @Override
    default void saveAllBooks(List<Book> entities){
        this.saveAll(entities);
    }
}
