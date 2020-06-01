package com.smittrial.demo;

import com.smittrial.demo.models.BookModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class SmitTrialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmitTrialApplication.class, args);
	}

	@GetMapping(value="getLibrarySummary", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> getLibrarySummary() {
		List<BookModel> books = BookModel.getBooks();
		List<String> booksResponse = new ArrayList<String>();

		for (BookModel book : books) {
			booksResponse.add(book.toString());
		}

		return new ResponseEntity<List<String>>(booksResponse, HttpStatus.OK);
	}
}
