package book;

import org.bookstore.book.Book;
import org.bookstore.book.BookCategory;
import org.bookstore.book.BookRepository;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class FakeBookRepository implements BookRepository {
    private final Map<Long, Book> books = new HashMap<>();

    @Override
    public Optional<Book> findBookById(Long id) {
        return Optional.ofNullable(books.get(id));
    }

    @Override
    public List<Book> findAllBooks() {
        return new ArrayList<>(books.values());
    }

    @Override
    public List<Book> findAllFreeBooks() {
        return books.values().stream().filter(book -> book.getPrice().equals(BigDecimal.ZERO)).collect(Collectors.toList());
    }

    @Override
    public List<Book> findAllPaidBooks() {
        return books.values().stream().filter(book -> book.getPrice().doubleValue() > 0.0).collect(Collectors.toList());
    }

    @Override
    public List<Book> findAllByName(String name) {
        return books.values().stream().filter(book -> book.getName().contains(name)).collect(Collectors.toList());
    }

    @Override
    public List<Book> findAllWithCategory(BookCategory category) {
        return books.values().stream().filter(book -> book.getCategory().equals(category)).collect(Collectors.toList());
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
