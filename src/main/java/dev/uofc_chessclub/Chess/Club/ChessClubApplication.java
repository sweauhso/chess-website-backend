package dev.uofc_chessclub.Chess.Club;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

public class ChessClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChessClubApplication.class, args);
	}

}
