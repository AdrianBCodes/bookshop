package org.bookstore.book;

import org.bookstore.book.exceptions.NotFoundException;

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
        var result = bookRepository.findBookById(id)
                .orElseThrow(() -> new NotFoundException("Book with id: " + id + " has not been found"));
        return result;
    }

    public List<Book> findAllBooks(){
        return bookRepository.findAllBooks();
    }

    public List<Book> findAllFreeBooks(){
        return bookRepository.findAllFreeBooks();
    }

    public List<Book> findAllPaidBooks(){
        return bookRepository.findAllPaidBooks();
    }

    public List<Book> findAllByName(String name){
        return bookRepository.findAllByName(name);
    }

    public List<Book> findAllByCategory(BookCategory category){
        return bookRepository.findAllWithCategory(category);
    }

    public void deleteBook(Book entity){
        bookRepository.deleteBook(entity);
    }

}
