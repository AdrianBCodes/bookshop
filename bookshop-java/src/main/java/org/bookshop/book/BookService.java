package org.bookshop.book;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public class BookService {
    private final BookProvider bookProvider;
    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    public BookService(BookProvider bookProvider) {
        this.bookProvider = bookProvider;
    }

    public Book findBookById(String id){
        logger.info("Searching for book with id: {}", id);
        return bookProvider.findBookById(id);
    }

    public Map<String, Book> findBooksByIds(List<String> ids){
        logger.info("Searching for books with ids: {}", ids);
        return bookProvider.findBooksByIds(ids);
    }

    public Page<Book> findAllBooks(Pageable pageable){
        logger.info("Retrieving all books with paging: {}", pageable);
        return bookProvider.findAllBooks(pageable);
    }

}
