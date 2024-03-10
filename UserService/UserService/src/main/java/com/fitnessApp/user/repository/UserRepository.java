package com.fitnessApp.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitnessApp.user.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	UserEntity findByUsername(String username);

}
