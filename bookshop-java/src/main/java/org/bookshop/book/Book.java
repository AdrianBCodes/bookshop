package org.bookshop.book;

import org.bookshop.book.dto.BookDTO;
import org.bookshop.product.Product;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;
import java.util.UUID;


@Document(collection = "books")
public class Book implements Product {

    @MongoId(FieldType.STRING)
    String id;
    String name;
    String description;
    BookCategory category;
    @Field(targetType = FieldType.DECIMAL128)
    BigDecimal price;

    public Book(String id, String name, String description, BookCategory category, BigDecimal price) {
        this.id = "Bk" + id;
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
}