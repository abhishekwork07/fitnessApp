package com.fitnessApp.activity.dto;

import com.fitnessApp.activity.util.ActivityTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDto {

	private Long id;
	private Long userId;
	private String activityName;
	private ActivityTypeEnum activityType;
	private String activityStats;

}
