package com.fitnessApp.login.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.fitnessApp.login.dto.RegistrationRequestDto;

public interface IUserLoginService extends UserDetailsService {

	public void registerUser(RegistrationRequestDto request);

}
