package org.bookshop.book.infrastructure;

import org.bookshop.book.BookCategory;


import java.math.BigDecimal;

public class BookWriteModel {
    String name;
    String description;
    BookCategory category;
    BigDecimal price;

    public BookWriteModel(){

    }

    public BookWriteModel(String name, String description, BookCategory category, BigDecimal price) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
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
