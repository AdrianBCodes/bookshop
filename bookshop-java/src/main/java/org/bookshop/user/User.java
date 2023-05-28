package org.bookshop.user;

import org.bson.types.ObjectId;

public class User {
    private ObjectId id;

    public User(ObjectId id) {
        this.id = id;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return String.format(
                "User:{id: %s}",
                id
        );
    }
}
