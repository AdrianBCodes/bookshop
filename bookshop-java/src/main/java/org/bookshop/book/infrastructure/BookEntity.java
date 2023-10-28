package org.bookshop.book.infrastructure;

import org.bookshop.book.BookCategory;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.math.BigDecimal;


@Document(collection = "books")
public class BookEntity {

    @MongoId(FieldType.STRING)
    String id;
    String name;
    String description;
    BookCategory category;
    @Field(targetType = FieldType.DECIMAL128)
    BigDecimal price;

    public BookEntity(String id, String name, String description, BookCategory category, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public BookEntity() {

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

}
