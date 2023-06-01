package org.bookshop.product;

import org.bookshop.book.BookService;
import org.bookshop.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final BookService bookService;

    public ProductService(BookService bookService) {
        this.bookService = bookService;
    }

    private final Logger logger = LoggerFactory.getLogger(ProductService.class);

    public Product getProductById(String id){
        if(id.startsWith("Bk"))
            return bookService.findBookById(id);
        logger.error("Product with id: {} not found", id);
        throw new NotFoundException(String.format("Product with id: %s not found", id));
    }
}
