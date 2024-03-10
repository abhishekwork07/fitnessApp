package com.fitnessApp.login.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fitnessApp.login.dto.RegistrationRequestDto;
import com.fitnessApp.login.dto.UserDto;
import com.fitnessApp.login.entity.UserLoginEntity;
import com.fitnessApp.login.repo.UserLoginRepository;

@Service
public class UserLoginService implements IUserLoginService {

	@Autowired
	private UserLoginRepository loginRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserClient client;

	@Override
	public void registerUser(RegistrationRequestDto request) {

		UserLoginEntity newUser = new UserLoginEntity();
		newUser.setUsername(request.getUsername());
		newUser.setPassword(passwordEncoder.encode(request.getPassword()));
		UserLoginEntity savedUser = loginRepository.save(newUser);

		LocalDateTime now = LocalDateTime.now();
		UserDto user = new UserDto(request.getUsername(), request.getEmail(), request.getFullName(), now,
				savedUser.getId());
		addUser(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserLoginEntity user = loginRepository.findByUsername(username);
		UserDetails userDetails = User.builder().username(user.getUsername())
				.password(user.getPassword()).build();
		return userDetails;
	}

	public List<UserLoginEntity> getAllRegisteredUsers() {
		return loginRepository.findAll();
	}

	public UserDto addUser(UserDto user) {
		return client.addUserDetails(user);
	}

}
