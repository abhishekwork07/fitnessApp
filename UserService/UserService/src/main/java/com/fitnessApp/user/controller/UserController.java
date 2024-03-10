package com.fitnessApp.user.controller;

import java.util.List;

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

import com.fitnessApp.user.entity.UserEntity;
import com.fitnessApp.user.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/add")
	public ResponseEntity<UserEntity> createUser(@RequestBody UserEntity user) {

		UserEntity createdUser = this.userService.createUser(user);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@GetMapping("/{username}")
	public ResponseEntity<UserEntity> getUser(@PathVariable("username") String username) {

		UserEntity user = userService.getUser(username);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping("/")
	public ResponseEntity<List<UserEntity>> getAllUser() {

		List<UserEntity> userList = userService.getAllUsers();
		return new ResponseEntity<>(userList, HttpStatus.OK);
	}

	@PutMapping("/update/{username}")
	public ResponseEntity<UserEntity> updateUser(@PathVariable("username") String username,
			@RequestBody UserEntity user) {

		UserEntity createdUser = userService.updateUser(username, user);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{username}")
	public ResponseEntity<String> deleteUser(@PathVariable("username") String username) {

		userService.deleteUser(username);
		return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
	}
}
