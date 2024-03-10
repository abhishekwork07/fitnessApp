package com.fitnessApp.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnessApp.login.dto.UserDto;

@Service
public class UserService {

	@Autowired
	private UserClient client;

	public UserDto getUser(String username) {
		return client.getUserDetails(username);
	}

	public UserDto updateUser(String username, UserDto user) {
		return client.updateUserDetails(username, user);
	}

	public String deleteUser(String username) {
		return client.deleteUserDetails(username);
	}

}
