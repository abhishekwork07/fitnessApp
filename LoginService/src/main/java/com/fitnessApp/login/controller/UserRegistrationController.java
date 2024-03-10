package com.fitnessApp.login.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitnessApp.login.dto.RegistrationRequestDto;
import com.fitnessApp.login.entity.UserLoginEntity;
import com.fitnessApp.login.service.UserLoginService;

@RestController
@RequestMapping("/register")
public class UserRegistrationController {

	@Autowired
	private UserLoginService userService;

	@PostMapping
	public ResponseEntity<String> registerUser(@RequestBody RegistrationRequestDto registrationRequest) {
		userService.registerUser(registrationRequest);
		return new ResponseEntity<>("New User registered successfully", HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<?> getRegisteredUser() {
		List<UserLoginEntity> registeredUser = userService.getAllRegisteredUsers();
		return ResponseEntity.ok().body(registeredUser);
	}

}
