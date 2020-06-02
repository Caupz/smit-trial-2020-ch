package com.smittrial.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.smittrial.demo.models.BookModel;
import com.smittrial.demo.models.BookOvertimeResult;
import com.smittrial.demo.models.UserModel;
import com.smittrial.demo.service.BookServiceImpl;
import com.smittrial.demo.service.LateBookLendingsServiceImpl;
import com.smittrial.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.smittrial.demo.utility.JSONUtils;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class SmitTrialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmitTrialApplication.class, args);
	}

	/*@GetMapping(value="test/getTest", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookModel>> getTest() {
		List<BookModel> listProduct = new ArrayList<BookModel>();
		listProduct.add(new BookModel(1));
		return new ResponseEntity<List<BookModel>>(listProduct, HttpStatus.OK);
	}*/

	@Autowired
	private BookServiceImpl bookServiceImpl;
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private LateBookLendingsServiceImpl lateBookLendingServiceImpl;

	@GetMapping(value="getLibrarySummary", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> getLibrarySummary() {
		List<BookModel> books = new ArrayList<>(bookServiceImpl.getAllBooks());
		List<String> booksResponse = new ArrayList<String>();

		for (BookModel book : books) {
			booksResponse.add(book.toString());
		}

		return new ResponseEntity<List<String>>(booksResponse, HttpStatus.OK);
	}
	@GetMapping(value="searchBookByName/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> searchBookByName(@PathVariable("name") String name) throws JsonProcessingException {
		UserModel user = new UserModel(); // TODO get user from somewhere

		if(!user.hasRole("library-worker-tender")) {
			return new ResponseEntity<String>(JSONUtils.covertFromObjectToJson("Access Denied"), HttpStatus.FORBIDDEN);
		}

		BookModel book = bookServiceImpl.getBookByNameContaining(name);

		if(book == null) {
			return new ResponseEntity<String>(JSONUtils.covertFromObjectToJson("No such book"), HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<String>(JSONUtils.covertFromObjectToJson(book.toString()), HttpStatus.OK);
	}
	@GetMapping(value="addUser/{email}/{password}/{firstname}/{lastname}/{ssn}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> addUser(
			@PathVariable("email") String email,
			@PathVariable("password") String password,
			@PathVariable("firstname") String firstname,
			@PathVariable("lastname") String lastname,
			@PathVariable("ssn") String ssn
	) throws JsonProcessingException {
		UserModel user = new UserModel(); // TODO get user from somewhere

		if(!user.hasRole("library-worker-tender")) {
			return new ResponseEntity<String>(JSONUtils.covertFromObjectToJson("Access Denied"), HttpStatus.FORBIDDEN);
		}

		UserModel newUser = new UserModel(email, password, firstname, lastname, ssn);
		newUser.setId(userServiceImpl.add(newUser));

		return new ResponseEntity<String>(JSONUtils.covertFromObjectToJson(newUser.toString()), HttpStatus.CREATED);
	}
	@GetMapping(value="getLateLenders", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BookOvertimeResult>> getLateLenders() throws JsonProcessingException, SQLException {
		UserModel user = new UserModel(); // TODO get user from somewhere
		List<BookOvertimeResult> bookOverTimes = new ArrayList<>(lateBookLendingServiceImpl.getAllLateBookLenders());

		if(!user.hasRole("library-worker")) {
			return new ResponseEntity<List<BookOvertimeResult>>(bookOverTimes, HttpStatus.FORBIDDEN);
		}

		return new ResponseEntity<List<BookOvertimeResult>>(bookOverTimes, HttpStatus.OK);
	}
}
