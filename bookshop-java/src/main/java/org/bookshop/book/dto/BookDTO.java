package org.bookshop.book.dto;

import org.bookshop.book.BookCategory;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class BookDTO {
    private final String id;
    private final String name;
    private final String description;
    private final BookCategory category;
    private final BigDecimal price;

    public BookDTO(String id, String name, String description, BookCategory category, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price.setScale(2, RoundingMode.DOWN);
    }

    public String getId() {
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

    @Override
    public String toString() {
        return String.format(
                "Book{id='%s', name='%s', description='%s', category=%s, price=%.2f}",
                id,
                name,
                description,
                category.toString(),
                price);
    }
}
