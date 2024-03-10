package com.fitnessApp.login.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitnessApp.login.dto.JwtRequestDto;
import com.fitnessApp.login.dto.JwtResponseDto;
import com.fitnessApp.login.security.jwt.JwtHelper;
import com.fitnessApp.login.service.UserLoginService;

@RestController
@RequestMapping("auth/login")
public class UserLoginController {

	@Autowired
	private UserLoginService userLoginService;

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private JwtHelper helper;

	private Logger logger = LoggerFactory.getLogger(UserLoginController.class);

	@PostMapping
	public ResponseEntity<JwtResponseDto> login(@RequestBody JwtRequestDto request) {

		this.doAuthenticate(request.getUsername(), request.getPassword());

		UserDetails userDetails = userLoginService.loadUserByUsername(request.getUsername());
		String token = this.helper.generateToken(userDetails);

		JwtResponseDto response = JwtResponseDto.builder().jwtToken(token).username(userDetails.getUsername()).build();
		return new ResponseEntity<JwtResponseDto>(response, HttpStatus.OK);
	}

	private void doAuthenticate(String username, String password) {

		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(username,
				password);
		try {
			manager.authenticate(authentication);

		} catch (BadCredentialsException e) {
			throw new BadCredentialsException(" Invalid Username or Password  !!");
		}

	}

	@ExceptionHandler(BadCredentialsException.class)
	public String exceptionHandler() {
		return "Credentials Invalid !!";
	}

}
