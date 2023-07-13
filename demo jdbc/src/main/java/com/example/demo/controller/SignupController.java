package com.example.demo.controller;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dao.SignupDao;
import com.example.demo.model.Response;
import com.example.demo.model.SignupModel;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")

public class SignupController {

    SignupDao dao=new SignupDao();
	 
//	@Autowired(required = true)
//	SignupDao dao;

	@PostMapping("/insert")
	public ResponseEntity<Response> addUsers(@RequestBody SignupModel data) {

		return ResponseEntity.ok(dao.addUsers(data));
	}

	@DeleteMapping("/delete")
	public ResponseEntity<Response> deleteUsers(@RequestBody SignupModel remove ) {

		return ResponseEntity.ok(dao.deleteUsers(remove));
	}

	@GetMapping("/retriveAll")
	public ResponseEntity<Response> getAllUsers() {

		return ResponseEntity.ok(dao.getAllUsers());
	}

	@GetMapping("/retrive")
	public ResponseEntity<Response> getUsersById(@RequestParam String sNo) {

		return ResponseEntity.ok(dao.getUsersById(sNo));
	}

	@PutMapping("/update")
	public ResponseEntity<Response> updatetUsers(@RequestBody SignupModel modify) {

		return ResponseEntity.ok(dao.updatetUsers(modify));
	}
}
