package com.fitnessApp.login.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitnessApp.login.entity.UserLoginEntity;

public interface UserLoginRepository extends JpaRepository<UserLoginEntity, Long> {

	UserLoginEntity findByUsername(String username);

}
