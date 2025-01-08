package dev.uofc_chessclub.Chess.Club;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.bson.types.ObjectId;

@Document(collection = "announcements")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Announcements {
    @Id
    private ObjectId id;

    private String title;

    private String description;

    private String date;

    private String link;

    private String picture;
}
