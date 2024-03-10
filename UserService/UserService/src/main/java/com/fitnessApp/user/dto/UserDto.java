package com.fitnessApp.user.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

	private Long id;

	private String username;

	private String email;

	private String fullName;

	private Date createdAt;

	private Long loginId;

}
