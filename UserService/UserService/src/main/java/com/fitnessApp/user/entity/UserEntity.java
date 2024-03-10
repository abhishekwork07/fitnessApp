package com.fitnessApp.user.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String email;

	private String fullName;

	private LocalDateTime createdAt;

	private Long loginId;

	public UserEntity(String username, String email, String fullName, LocalDateTime createdAt, Long loginId) {
		super();
		this.username = username;
		this.email = email;
		this.fullName = fullName;
		this.createdAt = createdAt;
		this.loginId = loginId;
	}
}
