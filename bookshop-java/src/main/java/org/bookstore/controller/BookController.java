package org.bookstore.controller;

import org.bookstore.book.Book;
import org.bookstore.book.BookBuilder;
import org.bookstore.book.BookCategory;
import org.bookstore.book.BookService;
import org.bookstore.book.infrastructure.BookWriteModel;
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
    ResponseEntity<List<Book>> findAllBooks() {
        return ResponseEntity.ok(bookService.findAllBooks());
    }

    @GetMapping("/free")
    ResponseEntity<List<Book>> findAllFreeBooks() {
        return ResponseEntity.ok(bookService.findAllFreeBooks());
    }

    @GetMapping("/paid")
    ResponseEntity<List<Book>> findAllPaidBooks() {
        return ResponseEntity.ok(bookService.findAllPaidBooks());
    }

    @GetMapping("/name/{name}")
    ResponseEntity<List<Book>> findAllByName(@PathVariable String name) {
        return ResponseEntity.ok(bookService.findAllByName(name));
    }

    @GetMapping("/category/{category}")
    ResponseEntity<List<Book>> findAllByCategory(@PathVariable BookCategory category) {
        return ResponseEntity.ok(bookService.findAllByCategory(category));
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(bookService.findBookById(id));
        return ResponseEntity.noContent().build();
    }
}
