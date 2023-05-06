package org.bookstore.book;

import org.bookstore.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book findBookById(Long id){
        return bookRepository.findBookById(id)
                .orElseThrow(() -> new NotFoundException("Book with id: " + id + " has not been found"));
    }

    public Page<Book> findAllBooks(Pageable pageable){
        return bookRepository.findAllBooks(pageable);
    }

}
