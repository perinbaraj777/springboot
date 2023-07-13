package com.demo.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.jpa.model.JPAModel;
import com.demo.jpa.model.Response;
import com.demo.jpa.service.JPAService;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class JPAController {

	// controller methods

	// JPAService srve = new JPAService();

	@Autowired
	private JPAService srve;
	
	@PostMapping("/insert")
	public ResponseEntity<Response> addUser(@RequestBody JPAModel add) {

		return ResponseEntity.ok(srve.addUser(add));
	}

	@GetMapping("/retriveAll")

	public ResponseEntity<Response> getAllUser() {

		return ResponseEntity.ok(srve.getAllUser());
	}

	@GetMapping("/retrive/{sNo}")

	public ResponseEntity<Response> getUser(@PathVariable String sNo) {

		return ResponseEntity.ok(srve.getUser(sNo));
	}

	@PutMapping("/update")

	public ResponseEntity<Response> updateUser(@RequestBody JPAModel update) {

		return ResponseEntity.ok(srve.updateUser(update));

	}

	@DeleteMapping("/delete/{delete}")

	public ResponseEntity<Response> deleteUser(@PathVariable String delete) {

		return ResponseEntity.ok(srve.deleteUser(delete));
	}

}
