package org.bookshop.product;

import org.bookshop.book.BookService;
import org.bookshop.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public Map<String, Product> getProductsByIds(List<String> ids){
        HashMap<String, Product> result = new HashMap<>();
        // for books
        result.putAll(bookService.findBooksByIds(
                ids.stream()
                .filter(id -> id.startsWith("Bk"))
                .collect(Collectors.toList()))
        );
        return result;
    }
}
