package book;

import org.bookstore.book.Book;
import org.bookstore.book.BookBuilder;
import org.bookstore.book.BookCategory;

import java.math.BigDecimal;

public class BookExample {

    public static Book getBook1() {
        return BookBuilder
                .builder()
                .withId(1L)
                .withName("Book1")
                .withDescription("BookDescription1")
                .withPrice(BigDecimal.ONE)
                .withCategory(BookCategory.DRAMA)
                .buildWithId();
    }

    public static Book getBook2() {
        return BookBuilder
                .builder()
                .withId(2L)
                .withName("Book2")
                .withDescription("BookDescription2")
                .withPrice(BigDecimal.TEN)
                .withCategory(BookCategory.SF)
                .buildWithId();
    }

}