package com.fitnessApp.activity.entity;

import java.time.LocalDateTime;

import com.fitnessApp.activity.util.ActivityTypeEnum;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Table(name = "activity")
public class ActivityEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private Long userId;
	private String activityName;
	private ActivityTypeEnum activityType;
	private String activityStats;
	private LocalDateTime date;

}
