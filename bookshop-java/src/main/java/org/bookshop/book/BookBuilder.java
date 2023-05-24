package org.bookshop.book;

import org.bson.types.ObjectId;

import java.math.BigDecimal;

public class BookBuilder {
    private ObjectId id;
    private String name;
    private String description;
    private BookCategory category;
    private BigDecimal price;

    public static BookBuilder builder(){
        return new BookBuilder();
    }

    public BookBuilder withId(ObjectId id){
        this.id = id;
        return this;
    }

    public BookBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public BookBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public BookBuilder withCategory(BookCategory category) {
        this.category = category;
        return this;
    }

    public BookBuilder withPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public Book build(){
        return new Book(name, description, category, price);
    }

    public Book buildWithId(){
        return new Book(id, name, description, category, price);
    }

}
