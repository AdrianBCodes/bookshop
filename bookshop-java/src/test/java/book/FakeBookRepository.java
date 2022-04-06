package book;

import org.bookstore.book.Book;
import org.bookstore.book.BookCategory;
import org.bookstore.book.BookRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FakeBookRepository implements BookRepository {
    private final Map<Long, Book> books = new HashMap<>();

    @Override
    public Optional<Book> findBookById(Long id) {
        return Optional.ofNullable(books.get(id));
    }

    @Override
    public Page<Book> findAllBooks(Pageable pageable) {
        var result = books.values().stream().toList();
        return new PageImpl<>(result, pageable, result.size());
    }

    @Override
    public Page<Book> findAllFreeBooks(Pageable pageable) {
        var result = books.values().stream().filter(book -> book.getPrice().equals(BigDecimal.ZERO)).toList();
        return new PageImpl<>(result, pageable, result.size());
    }

    @Override
    public Page<Book> findAllPaidBooks(Pageable pageable) {
        var result = books.values().stream().filter(book -> book.getPrice().doubleValue() > 0.0).toList();
        return new PageImpl<>(result, pageable, result.size());
    }

    @Override
    public Page<Book> findAllByName(String name, Pageable pageable) {
        var result = books.values().stream().filter(book -> book.getName().contains(name)).toList();
        return new PageImpl<>(result, pageable, result.size());
    }

    @Override
    public Page<Book> findAllWithCategory(BookCategory category, Pageable pageable) {
        var result = books.values().stream().filter(book -> book.getCategory().equals(category)).toList();
        return new PageImpl<>(result, pageable, result.size());
    }

    @Override
    public Long saveBook(Book entity) {
        if(entity.getId() == null){
            var index = Collections.max(books.keySet()) + 1;
            var toSave = new Book(index, entity.getName(), entity.getDescription(), entity.getCategory(), entity.getPrice());
            books.put(index, toSave);
            return index;
        }
        books.put(entity.getId(), entity);
        return entity.getId();
    }

    @Override
    public void deleteBook(Book entity) {
        books.remove(entity.getId(), entity);
    }
}
