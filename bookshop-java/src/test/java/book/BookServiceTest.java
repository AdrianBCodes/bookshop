package book;

import org.bookstore.book.Book;
import org.bookstore.book.BookCategory;
import org.bookstore.book.BookService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.BDDAssertions.*;

class BookServiceTest {
    private BookService bookService;

    @BeforeEach
    void init(){
        bookService = new BookService(new FakeBookRepository());
    }

    @Test
    public void addBook() {
        // given
        Book book = new Book(1L,"Book1", "Desc1", BookCategory.DRAMA, BigDecimal.ONE);
        //when
        bookService.addBook(book);
        // then
        assertThat(bookService.findBookById(1L)).isEqualTo(book);
    }

    @Test
    public void editBook() {
        // given
        Book book = new Book(1L,"Book1", "Desc1", BookCategory.DRAMA, BigDecimal.ONE);
        Book book2 = new Book(1L,"Book2", "Desc2", BookCategory.DRAMA, BigDecimal.ONE);
        bookService.addBook(book);
        //when
        bookService.editBook(book2);
        // then
        assertThat(bookService.findBookById(1L)).isEqualTo(book2);
    }

    @Test
    public void findById() {
        // given
        Book book = new Book(1L,"Book1", "Desc1", BookCategory.DRAMA, BigDecimal.ONE);
        bookService.addBook(book);
        // when
        var result = bookService.findBookById(1L);
        // then
        assertThat(result).isEqualTo(book);
    }

    @Test
    public void findById_ThrowsException() {
        // given

        // when
        var exception = catchThrowable(() -> bookService.findBookById(1L));
        // then
        assertThat(exception).isInstanceOf(RuntimeException.class);
    }

    @Test
    public void findAll() {
        // given
        Book book = new Book(1L,"Book1", "Desc1", BookCategory.DRAMA, BigDecimal.ONE);
        Book book2 = new Book(2L,"Book2", "Desc2", BookCategory.THRILLER, BigDecimal.ZERO);
        bookService.addBook(book);
        bookService.addBook(book2);
        // when
        var result = bookService.findAllBooks();
        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0)).isEqualTo(book);
        assertThat(result.get(1)).isEqualTo(book2);
    }

    @Test
    public void findAllFreeBooks() {
        // given
        Book book = new Book(1L,"Book1", "Desc1", BookCategory.DRAMA, BigDecimal.ONE);
        Book book2 = new Book(2L,"Book2", "Desc2", BookCategory.THRILLER, BigDecimal.ZERO);
        bookService.addBook(book);
        bookService.addBook(book2);
        // when
        var result = bookService.findAllFreeBooks();
        // then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0)).isEqualTo(book2);
    }

    @Test
    public void findAllPaidBooks() {
        // given
        Book book = new Book(1L,"Book1", "Desc1", BookCategory.DRAMA, BigDecimal.ONE);
        Book book2 = new Book(2L,"Book2", "Desc2", BookCategory.THRILLER, BigDecimal.ZERO);
        bookService.addBook(book);
        bookService.addBook(book2);
        // when
        var result = bookService.findAllPaidBooks();
        // then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0)).isEqualTo(book);
    }

    @Test
    public void findAllByName() {
        // given
        Book book = new Book(1L,"Book1", "Desc1", BookCategory.DRAMA, BigDecimal.ONE);
        Book book2 = new Book(2L,"Book2", "Desc2", BookCategory.THRILLER, BigDecimal.ZERO);
        Book book3 = new Book(3L,"Something", "Desc2", BookCategory.THRILLER, BigDecimal.ZERO);
        bookService.addBook(book);
        bookService.addBook(book2);
        bookService.addBook(book3);
        // when
        var result = bookService.findAllByName("Book");
        // then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getName()).isEqualTo("Book1");
        assertThat(result.get(1).getName()).isEqualTo("Book2");
    }

    @Test
    public void findAllByCategory() {
        // given
        Book book = new Book(1L,"Book1", "Desc1", BookCategory.DRAMA, BigDecimal.ONE);
        Book book2 = new Book(2L,"Book2", "Desc2", BookCategory.THRILLER, BigDecimal.ZERO);
        bookService.addBook(book);
        bookService.addBook(book2);
        // when
        var result = bookService.findAllByCategory(BookCategory.DRAMA);
        // then
        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0)).isEqualTo(book);

    }
    @Test
    public void deleteBook() {
        // given
        Book book = new Book(1L,"Book1", "Desc1", BookCategory.DRAMA, BigDecimal.ONE);
        bookService.addBook(book);
        bookService.deleteBook(book);
        // when
        var result = bookService.findAllBooks();
        // then
        assertThat(result).isEqualTo(List.of());
    }

    @Test
    public void deleteBook_ThrowsRuntimeException() {
        // given
        Book book = new Book(1L,"Book1", "Desc1", BookCategory.DRAMA, BigDecimal.ONE);
        bookService.deleteBook(book);
        // when
        var exception = catchThrowable(() -> bookService.findBookById(1L));
        // then
        assertThat(exception).isInstanceOf(RuntimeException.class);
    }
}