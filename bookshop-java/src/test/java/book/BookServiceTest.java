package book;

import org.bookshop.book.*;
import org.bookshop.book.infrastructure.BookEntity;
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
    private BookProvider bookProvider;

    @BeforeEach
    void init() {
        MockitoAnnotations.openMocks(this);
        bookRepositoryMock = mock(BookRepository.class);
        bookProvider = new BookProvider(bookRepositoryMock);
        bookService = new BookService(bookProvider);
    }

    @Test
    public void findById() {
        // given
        Book book = BookExample.getBook1();
        BookEntity bookEntity = BookMapper.bookDomainToEntity(book);
        given(bookRepositoryMock.saveBook(bookEntity)).willReturn(book.getId());
        given(bookRepositoryMock.findBookById(book.getId())).willReturn(Optional.of(bookEntity));
        bookRepositoryMock.saveBook(bookEntity);
        // when
        var result = bookService.findBookById(book.getId());
        // then
        then(bookRepositoryMock).should().findBookById(book.getId());
        assertThat(result).isEqualTo(book);
    }

    @Test
    public void findById_ThrowsException() {
        // given
        String bookId = "Bk1";
        given(bookRepositoryMock.findBookById(bookId)).willReturn(Optional.empty());
        // when
        var exception = catchThrowable( () -> bookService.findBookById(bookId));
        // then
        assertThat(exception).isInstanceOf(NotFoundException.class);
    }

    @Test
    public void findAll() {
        // given
        Book book = BookExample.getBook1();
        Book book2 = BookExample.getBook2();
        BookEntity bookEntity1 = BookExample.getBookEntity1();
        BookEntity bookEntity2 = BookExample.getBookEntity2();
        given(bookRepositoryMock.findAllBooks(PageRequest.of(0, 5)))
                .willReturn(new PageImpl<>(List.of(bookEntity1, bookEntity2), PageRequest.of(0, 5), 2));
        // when
        var result = bookService.findAllBooks(PageRequest.of(0,5));
        // then
        then(bookRepositoryMock).should().findAllBooks(PageRequest.of(0,5));
        assertThat(result.getContent().size()).isEqualTo(2);
        assertThat(result.getContent().get(0)).isEqualTo(book);
        assertThat(result.getContent().get(1)).isEqualTo(book2);
    }
}