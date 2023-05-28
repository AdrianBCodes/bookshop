package org.bookshop.user.infrastructure;

import org.bookshop.user.User;
import org.bookshop.user.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface SqlUserRepository extends UserRepository, MongoRepository<User, ObjectId> {

    @Override
    default Optional<User> getUserById(ObjectId userId){
        return this.findById(userId);
    }
}
