package org.bookstore.controller;

import org.bookstore.book.Book;
import org.bookstore.book.BookBuilder;
import org.bookstore.book.BookCategory;
import org.bookstore.book.BookService;
import org.bookstore.book.infrastructure.BookWriteModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    ResponseEntity<Long> addBook(@RequestBody BookWriteModel toSave) {
        var bookToAdd = BookBuilder.builder()
                .withName(toSave.getName())
                .withDescription(toSave.getDescription())
                .withCategory(toSave.getCategory())
                .withPrice(toSave.getPrice())
                .build();
        var bookId = bookService.addBook(bookToAdd);
        return ResponseEntity.ok(bookId);
    }

    @PutMapping("/{id}")
    ResponseEntity<?> editBook(@PathVariable Long id, @RequestBody BookWriteModel toEdit) {
        var bookToEdit =
                BookBuilder.builder()
                .withId(id)
                .withName(toEdit.getName())
                .withDescription(toEdit.getDescription())
                .withCategory(toEdit.getCategory())
                .withPrice(toEdit.getPrice())
                .buildWithId();
        bookService.editBook(bookToEdit);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/{id}")
    ResponseEntity<Book> findBookById(@PathVariable Long id) {
        return ResponseEntity.ok(bookService.findBookById(id));
    }

    @GetMapping
    ResponseEntity<List<Book>> findAllBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
        ) {
        Pageable paging = PageRequest.of(page, size);
        return ResponseEntity.ok(bookService.findAllBooks(paging).getContent());
    }

    @GetMapping("/free")
    ResponseEntity<List<Book>> findAllFreeBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        Pageable paging = PageRequest.of(page, size);
        return ResponseEntity.ok(bookService.findAllFreeBooks(paging).getContent());
    }

    @GetMapping("/paid")
    ResponseEntity<List<Book>> findAllPaidBooks(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
    ) {
        Pageable paging = PageRequest.of(page, size);
        return ResponseEntity.ok(bookService.findAllPaidBooks(paging).getContent());
    }

    @GetMapping("/name/{name}")
    ResponseEntity<List<Book>> findAllByName(
            @PathVariable String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
        ) {
        Pageable paging = PageRequest.of(page, size);
        return ResponseEntity.ok(bookService.findAllByName(name, paging).getContent());
    }

    @GetMapping("/category/{category}")
    ResponseEntity<List<Book>> findAllByCategory(
            @PathVariable BookCategory category,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "3") int size
        ) {
        Pageable paging = PageRequest.of(page, size);
        return ResponseEntity.ok(bookService.findAllByCategory(category, paging).getContent());
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(bookService.findBookById(id));
        return ResponseEntity.noContent().build();
    }
}
