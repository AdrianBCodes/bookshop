package org.bookshop.book;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;

@Document(collection = "books")
public class Book {

    @MongoId
    String id;
    String name;
    String description;
    BookCategory category;
    @Field(targetType = FieldType.DECIMAL128)
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

    @Override
    public String toString() {
        return String.format(
                "Book{id='%s', name='%s', description='%s', category=%s, price=%.2f",
                id,
                name,
                description,
                category.toString(),
                price);
    }
}