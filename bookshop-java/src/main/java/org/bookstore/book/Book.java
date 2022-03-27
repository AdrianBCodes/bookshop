package org.bookstore.book;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    String name;
    String description;
    BookCategory category;
    BigDecimal price;

    public Book(Long id, String name, String description, BookCategory category, BigDecimal price) {
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

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BookCategory getCategory() {
        return category;
    }

    public BigDecimal getPrice() {
        return price;
    }
}