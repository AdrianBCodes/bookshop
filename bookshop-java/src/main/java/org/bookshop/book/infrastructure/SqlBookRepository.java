package org.bookshop.book.infrastructure;

import com.mongodb.lang.NonNull;
import org.bookshop.book.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;


public interface SqlBookRepository extends BookRepository, MongoRepository<BookEntity, String> {
    @NonNull
    Page<BookEntity> findAll(@NonNull Pageable pageable);

    Set<BookEntity> findBooksByIdIn(List<String> ids);

    @Override
    default Optional<BookEntity> findBookById(String id){
        return this.findById(id);
    }

    @Override
    default Map<String, BookEntity> findBooksByIds(List<String> ids) {
        return this.findBooksByIdIn(ids).stream()
                .collect(Collectors.toMap(
                        BookEntity::getId,
                        bookEntity -> bookEntity
        ));
    }

    @Override
    default Page<BookEntity> findAllBooks(Pageable pageable) {
        return this.findAll(pageable);
    }

    @Override
    default String saveBook(BookEntity entity) {
        this.save(entity);
        return entity.getId();
    }

    @Override
    default void saveAllBooks(List<BookEntity> entities){
        this.saveAll(entities);
    }
}
