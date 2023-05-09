package book;

import org.bookshop.book.Book;
import org.bookshop.book.BookRepository;
import org.bookshop.book.BookService;
import org.bookshop.exceptions.NotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.BDDAssertions.assertThat;
import static org.assertj.core.api.BDDAssertions.catchThrowable;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;

class BookServiceTest {
    private BookRepository bookRepositoryMock;

    private BookService bookService;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        bookRepositoryMock = mock(BookRepository.class);
        bookService = new BookService(bookRepositoryMock);
    }

    @Test
    public void findById() {
        // given
        Book book = BookExample.getBook1();
        given(bookRepositoryMock.saveBook(book)).willReturn("1");
        given(bookRepositoryMock.findBookById(1L)).willReturn(Optional.of(book));
        bookRepositoryMock.saveBook(book);
        // when
        var result = bookService.findBookById(1L);
        // then
        then(bookRepositoryMock).should().findBookById(1L);
        assertThat(result).isEqualTo(book);
    }

    @Test
    public void findById_ThrowsException() {
        // given
        given(bookRepositoryMock.findBookById(1L)).willReturn(Optional.empty());
        // when
        var exception = catchThrowable( () -> bookService.findBookById(1L));
        // then
        assertThat(exception).isInstanceOf(NotFoundException.class);
    }

    @Test
    public void findAll() {
        // given
        Book book = BookExample.getBook1();
        Book book2 = BookExample.getBook2();
        given(bookRepositoryMock.findAllBooks(PageRequest.of(0, 5)))
                .willReturn(new PageImpl<>(List.of(book, book2), PageRequest.of(0, 5), 2));
        // when
        var result = bookService.findAllBooks(PageRequest.of(0,5));
        // then
        then(bookRepositoryMock).should().findAllBooks(PageRequest.of(0,5));
        assertThat(result.getContent().size()).isEqualTo(2);
        assertThat(result.getContent().get(0)).isEqualTo(book);
        assertThat(result.getContent().get(1)).isEqualTo(book2);
    }
}