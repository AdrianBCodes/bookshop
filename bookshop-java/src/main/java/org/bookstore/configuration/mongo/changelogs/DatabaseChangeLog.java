package org.bookstore.configuration.mongo.changelogs;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import com.github.cloudyrock.mongock.driver.mongodb.springdata.v3.decorator.impl.MongockTemplate;
import org.bookstore.book.BookRepository;
import org.bookstore.common.InitDataGenerator;
import org.bson.Document;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.schema.JsonSchemaProperty;
import org.springframework.data.mongodb.core.schema.MongoJsonSchema;

@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet(order = "001", id = "initBooksCollection", author = "AdrianBCodes")
    public void initBooksCollection(MongockTemplate template){
        MongoJsonSchema schema = MongoJsonSchema.builder()
                .properties(
                        JsonSchemaProperty.string("name"),
                        JsonSchemaProperty.string("description"),
                        JsonSchemaProperty.string("category"),
                        JsonSchemaProperty.decimal128("price"))
                .build();
        template.createCollection("books", CollectionOptions.empty().schema(schema));
    }

    @ChangeSet(order = "002", id = "initBooksData", author = "AdrianBCodes")
    public void initBooksData(BookRepository bookRepository){
        bookRepository.saveAllBooks(InitDataGenerator.generateBooks(15));
    }

    @ChangeSet(order = "003", id = "changeBooksValidation", author = "AdrianBCodes")
    public void changeBooksValidation(MongockTemplate template){
        MongoJsonSchema schema = MongoJsonSchema.builder()
                .required("_id")
                .properties(
                        JsonSchemaProperty.string("name"),
                        JsonSchemaProperty.string("description"),
                        JsonSchemaProperty.string("category"),
                        JsonSchemaProperty.decimal128("price"))
                .build();
        template.executeCommand(new Document("collMod", "books").append("validator", schema.toDocument()));
    }
}
