package org.bookshop.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bookshop.book.Book;
import org.bookshop.book.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/books")
@Api(value = "Books API")
public class BookController {
    private final BookService bookService;
    private final Logger logger = LoggerFactory.getLogger(BookController.class);

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find a book by Id", response = Book.class)
    ResponseEntity<Book> findBookById(@PathVariable Long id) {
        logger.info("Sent request to find book by id: {}", id);
        Book book = bookService.findBookById(id);
        logger.info("Returning book: {}", book);
        return ResponseEntity.ok(book);
    }

    @GetMapping
    @ApiOperation(value = "Find all books paged", response = Page.class)
    ResponseEntity<Page<Book>> findAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
        ) {
        Pageable paging = PageRequest.of(page, size);
        logger.info("Sent request to find all books with paging: {}", paging);
        Page<Book> books = bookService.findAllBooks(paging);
        logger.info("Returning {} books with paging {}", books.getTotalElements(), paging);
        return ResponseEntity.ok(books);
    }
}
