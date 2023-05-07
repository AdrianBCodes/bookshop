package org.bookstore.configuration.mongo.changelogs;

import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.bookstore.book.BookRepository;
import org.bookstore.common.InitDataGenerator;

@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet(order = "001", id = "initDatabase", author = "AdrianBCodes")
    public void initDatabase(BookRepository bookRepository){
        bookRepository.saveAllBooks(InitDataGenerator.generateBooks(15));
    }
}
