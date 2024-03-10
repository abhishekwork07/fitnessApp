package com.fitnessApp.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnessApp.user.entity.UserEntity;
import com.fitnessApp.user.repository.UserRepository;

@Service
public class UserService implements IUserService {


	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ActivityClient activityClient;

	@Override
	public UserEntity createUser(UserEntity user) {
		return userRepository.save((user));
	}

	@Override
	public UserEntity getUser(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserEntity updateUser(String username, UserEntity user) {
		UserEntity byUsername = userRepository.findByUsername(username);
		if (byUsername != null) {
			byUsername.setEmail(user.getEmail());
			byUsername.setFullName(user.getFullName());
			byUsername.setUsername(user.getUsername());
			userRepository.save(byUsername);
		}
		return null;
	}

	@Override
	public void deleteUser(String username) {
		UserEntity byUsername = userRepository.findByUsername(username);
		if (byUsername != null) {
			userRepository.deleteById(byUsername.getId());
		}
	}


}
