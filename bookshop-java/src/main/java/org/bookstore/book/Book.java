package org.bookstore.book;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;

@Document(collection = "books")
public class Book {

    @MongoId
    String id;
    String name;
    String description;
    BookCategory category;
    BigDecimal price;

    public Book(String id, String name, String description, BookCategory category, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public Book(String name, String description, BookCategory category, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public Book() {

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}