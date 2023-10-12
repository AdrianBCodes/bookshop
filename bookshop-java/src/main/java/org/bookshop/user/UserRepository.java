package org.bookshop.user;

import org.bson.types.ObjectId;

import java.util.Optional;

public interface UserRepository {
    Optional<User> getUserById(ObjectId userId);
    ObjectId saveUser(User user);
}
