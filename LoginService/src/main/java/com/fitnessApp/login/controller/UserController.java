package com.fitnessApp.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitnessApp.login.dto.UserDto;
import com.fitnessApp.login.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/{username}")
	public ResponseEntity<UserDto> getUser(@PathVariable String username) {
		UserDto user = service.getUser(username);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@PutMapping("/update/{username}")
	public ResponseEntity<UserDto> updateUser(@PathVariable String username, @RequestBody UserDto user) {
		UserDto updatedUser = service.updateUser(username, user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{username}")
	public ResponseEntity<String> deleteUser(@PathVariable String username) {
		String message = service.deleteUser(username);
		return new ResponseEntity<>(message, HttpStatus.OK);
	}

}
