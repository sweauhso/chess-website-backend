package dev.uofc_chessclub.Chess.Club;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnnouncementService {
    @Autowired
    private AnnouncementRepository announcementRepository;

    public List<Announcements> allAnnouncements() {
        return announcementRepository.findAll();
    }

    public Announcements singleAnnouncement(String title) {
        return announcementRepository.findByTitle(title).orElse(null);
    }

    public Announcements saveAnnouncement(Announcements newAnnouncement) {
        return announcementRepository.save(newAnnouncement);
    }

    public boolean deleteAnnouncementByTitle(String title) {
        // Find the announcement by title
        Optional<Announcements> announcement = announcementRepository.findByTitle(title);
        if (announcement.isPresent()) {
            // If found, delete the announcement
            announcementRepository.delete(announcement.get());
            return true;
        }
        return false; // Return false if the announcement is not found
    }
}
