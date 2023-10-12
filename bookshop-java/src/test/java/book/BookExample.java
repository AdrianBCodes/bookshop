package book;

import org.bookshop.book.Book;
import org.bookshop.book.BookBuilder;
import org.bookshop.book.BookCategory;

import java.math.BigDecimal;

public class BookExample {

    public static Book getBook1() {
        return BookBuilder
                .builder()
                .withId("1")
                .withName("Book1")
                .withDescription("BookDescription1")
                .withPrice(BigDecimal.ONE)
                .withCategory(BookCategory.DRAMA)
                .buildWithId();
    }

    public static Book getBook2() {
        return BookBuilder
                .builder()
                .withId("2")
                .withName("Book2")
                .withDescription("BookDescription2")
                .withPrice(BigDecimal.TEN)
                .withCategory(BookCategory.SF)
                .buildWithId();
    }

}
