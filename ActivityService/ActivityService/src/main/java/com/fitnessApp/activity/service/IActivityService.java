package com.fitnessApp.activity.service;

import java.util.List;

import com.fitnessApp.activity.dto.ActivityDto;

public interface IActivityService {

	public ActivityDto addActivity(ActivityDto activity);

	public ActivityDto updateActivity(Long id, ActivityDto activity);

	public List<ActivityDto> getAllActivities();

	public List<ActivityDto> getAllActivitiesByUser(Long userId);

	public ActivityDto getActivityById(Long id);

	public List<ActivityDto> getActivityByType(String type);

	public void deleteActivity(Long id);

}
