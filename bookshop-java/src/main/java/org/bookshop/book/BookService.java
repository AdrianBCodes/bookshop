package org.bookshop.book;

import org.bookshop.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BookService {
    private final BookRepository bookRepository;
    private final Logger logger = LoggerFactory.getLogger(BookService.class);

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findBookById(String id){
        logger.info("Searching for book with id: {}", id);
        return bookRepository.findBookById(id)
                .orElseThrow(() -> {
                    logger.error("Book with id: {} not found", id);
                    return new NotFoundException(String.format("Book with id: %s not found", id));
                });
    }

    public Page<Book> findAllBooks(Pageable pageable){
        logger.info("Retrieving all books with paging: {}", pageable);
        return bookRepository.findAllBooks(pageable);
    }

}
