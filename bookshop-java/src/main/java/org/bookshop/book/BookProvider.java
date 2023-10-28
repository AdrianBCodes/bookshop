package org.bookshop.book;

import org.bookshop.book.infrastructure.BookEntity;
import org.bookshop.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookProvider {
    private final BookRepository bookRepository;

    private static final Logger logger = LoggerFactory.getLogger(BookProvider.class);

    public BookProvider(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findBookById(String id){
        logger.info("Finding book with id: {}", id);
        BookEntity bookEntity = bookRepository.findBookById(id)
                .orElseThrow(() -> {
                    logger.error("Book with id: {} not found", id);
                    return new NotFoundException(String.format("Book with id: %s not found", id));
                });
        return BookMapper.bookEntityToDomain(bookEntity);
    }

    public Map<String, Book> findBooksByIds(List<String> ids){
        logger.info("Finding books with ids: {}", ids);
        Map<String, BookEntity> bookEntityMap = bookRepository.findBooksByIds(ids);

        return bookEntityMap.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> BookMapper.bookEntityToDomain(entry.getValue())
                ));
    }

    public Page<Book> findAllBooks(Pageable pageable){
        logger.info("Finding all books with paging: {}", pageable);
        return bookRepository.findAllBooks(pageable)
                .map(BookMapper::bookEntityToDomain);
    }

}
