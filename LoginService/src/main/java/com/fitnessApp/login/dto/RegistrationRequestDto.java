package com.fitnessApp.login.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegistrationRequestDto {

	private String username;
	private String password;
	private String email;
	private String fullName;
}
