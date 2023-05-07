package org.bookstore.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.bookstore.book.Book;
import org.bookstore.book.BookService;
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

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Find a book by Id", response = Book.class)
    ResponseEntity<Book> findBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findBookById(id));
    }

    @GetMapping
    @ApiOperation(value = "Find all books paged", response = Page.class)
    ResponseEntity<Page<Book>> findAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
        ) {
        Pageable paging = PageRequest.of(page, size);
        return ResponseEntity.ok(bookService.findAllBooks(paging));
    }
}
