package com.fitnessApp.login.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private String username;

	private String email;

	private String fullName;

	private LocalDateTime createdAt;

	private Long loginId;

}
