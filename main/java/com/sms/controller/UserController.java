package com.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sms.domain.entities.UserEntity;
import com.sms.service.UserService;

@RestController
@RequestMapping(value = "users")
public class UserController {

	@Autowired
	private UserService userservice;

	@PostMapping("/register")
	public ResponseEntity<Boolean> createUser(@RequestBody UserEntity userEntity) {
		return ResponseEntity.status(HttpStatus.CREATED).body(userservice.createUser(userEntity));
	}
	
	@GetMapping("{userId}")
	public ResponseEntity<UserEntity> getUserById(@PathVariable String userId) {
		return ResponseEntity.ok((userservice.getUserById(userId)));
	}
	
	@PutMapping("{userId}")
	public ResponseEntity<Boolean> updateUser(@PathVariable String userId, @RequestBody UserEntity entity){
		return ResponseEntity.ok(userservice.updateUser(entity));
	}
	@DeleteMapping("{userId}")
	public ResponseEntity<Boolean> deleteUser(@PathVariable String userId){
		return ResponseEntity.ok(userservice.deleteUser(userId));
	}
}
