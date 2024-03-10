package com.fitnessApp.login.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.fitnessApp.login.dto.UserDto;

@FeignClient(name = "USER-SERVICE")
public interface UserClient {

	@PostMapping("/api/user/add")
	UserDto addUserDetails(@RequestBody UserDto user);

	@GetMapping("/api/user/{username}")
	UserDto getUserDetails(@PathVariable String username);

	@PutMapping("/api/user/update/{username}")
	UserDto updateUserDetails(@PathVariable String username, @RequestBody UserDto user);

	@DeleteMapping("/api/user/delete/{username}")
	String deleteUserDetails(@PathVariable String username);

}
