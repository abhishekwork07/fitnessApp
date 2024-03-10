package com.fitnessApp.user.dto;

import java.util.Map;

public class ActivityDto {

	private Long userId;
	private String activityName;
	private String activityType;
	private Map<String, String> activityStats;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public Map<String, String> getActivityStats() {
		return activityStats;
	}

	public void setActivityStats(Map<String, String> activityStats) {
		this.activityStats = activityStats;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	@Override
	public String toString() {
		return "ActivityDto [userId=" + userId + ", activityName=" + activityName + ", activityType=" + activityType
				+ ", activityStats=" + activityStats + "]";
	}

}
