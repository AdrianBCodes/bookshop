package org.bookstore.book;

import org.bookstore.book.exceptions.NotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Long addBook(Book toSave){
        return bookRepository.saveBook(toSave);
    }

    public void editBook(Book toSave){
        bookRepository.saveBook(toSave);
    }

    public Book findBookById(Long id){
        return bookRepository.findBookById(id)
                .orElseThrow(() -> new NotFoundException("Book with id: " + id + " has not been found"));
    }

    public Page<Book> findAllBooks(Pageable pageable){
        return bookRepository.findAllBooks(pageable);
    }

    public Page<Book> findAllFreeBooks(Pageable pageable){
        return bookRepository.findAllFreeBooks(pageable);
    }

    public Page<Book> findAllPaidBooks(Pageable pageable){
        return bookRepository.findAllPaidBooks(pageable);
    }

    public Page<Book> findAllByName(String name, Pageable pageable){
        return bookRepository.findAllByName(name, pageable);
    }

    public Page<Book> findAllByCategory(BookCategory category, Pageable pageable){
        return bookRepository.findAllWithCategory(category, pageable);
    }

    public void deleteBook(Book entity){
        bookRepository.deleteBook(entity);
    }

}
