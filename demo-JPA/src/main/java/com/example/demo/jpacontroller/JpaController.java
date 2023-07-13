package com.example.demo.jpacontroller;

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
import com.example.demo.jpaService.JpaService;
import com.example.demo.model.JpaModel;
import com.example.demo.model.Response;

@CrossOrigin("*")
@RestController
@RequestMapping("/auth")
public class JpaController {

//	JpaService service = new JpaService();
	
	@Autowired
	private JpaService service;

	@PostMapping("/insert")
	public ResponseEntity<Response> addUsers(@RequestBody JpaModel add) {

		return ResponseEntity.ok(service.addUsers(add));

	}

	@DeleteMapping("/delete")
	public ResponseEntity<Response> deleteUsers(@PathVariable String remove) {

		return ResponseEntity.ok(service.deleteUsers(remove));

	}

	@PutMapping("/update")
	public ResponseEntity<Response> updateUsers(@RequestBody JpaModel modify) {        //modify is a parameter and is user defined

		return ResponseEntity.ok(service.updateUsers(modify));
	}

	@GetMapping("/retrive")
	public ResponseEntity<Response> getUsers(@PathVariable String sNo) {
		return ResponseEntity.ok(service.getUsers(sNo));
	}

	@GetMapping("/retriveAll")
	public ResponseEntity<Response> getAllUsers() {

		return ResponseEntity.ok(service.getAllUsers());
	}

}
