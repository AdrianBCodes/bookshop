package org.bookshop.book;

import org.bookshop.book.dto.BookDTO;
import org.bookshop.product.Product;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.UUID;


public class Book implements Product {

    private String id;
    private String name;
    private String description;
    private BookCategory category;
    private BigDecimal price;

    public Book(String id, String name, String description, BookCategory category, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public Book(String name, String description, BookCategory category, BigDecimal price) {
        this.id = "Bk" + UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public Book() {

    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public BookCategory getCategory() {
        return category;
    }

    @Override
    public BigDecimal getPrice() {
        return price;
    }

    public BookDTO toDto(){
        return new BookDTO(
                id,
                name,
                description,
                category,
                price
        );
    }

    @Override
    public String toString() {
        return String.format(
                "Book{id='%s', name='%s', description='%s', category=%s, price=%f}",
                id,
                name,
                description,
                category.toString(),
                price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, description, category, price);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return Objects.equals(id, other.id) &&
                Objects.equals(name, other.name) &&
                Objects.equals(description, other.description) &&
                category == other.category &&
                Objects.equals(price, other.price);
    }
}