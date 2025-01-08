package dev.uofc_chessclub.Chess.Club;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContactRepository extends MongoRepository<Contact, ObjectId> {
    Optional<Contact> findByName(String name);
}
