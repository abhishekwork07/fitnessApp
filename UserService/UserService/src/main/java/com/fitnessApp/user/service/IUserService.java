package com.fitnessApp.user.service;

import java.util.List;

import com.fitnessApp.user.entity.UserEntity;

public interface IUserService {

	public UserEntity getUser(String username);

	public List<UserEntity> getAllUsers();

	public UserEntity createUser(UserEntity user);

	public UserEntity updateUser(String username, UserEntity user);

	public void deleteUser(String username);

}
