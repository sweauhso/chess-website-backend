package dev.uofc_chessclub.Chess.Club;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnnouncementRepository extends MongoRepository<Announcements, ObjectId> {
    Optional<Announcements> findByTitle(String title);
}
