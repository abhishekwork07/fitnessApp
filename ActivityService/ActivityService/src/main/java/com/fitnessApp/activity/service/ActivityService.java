package com.fitnessApp.activity.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnessApp.activity.ResourceNotFoundException;
import com.fitnessApp.activity.dto.ActivityDto;
import com.fitnessApp.activity.entity.ActivityEntity;
import com.fitnessApp.activity.repo.ActivityRepository;
import com.fitnessApp.activity.util.ActivityTypeEnum;

@Service
public class ActivityService implements IActivityService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ActivityRepository activityRepo;

	private static final Logger logger = LoggerFactory.getLogger(ActivityService.class);

	private ActivityEntity dtoToActivity(ActivityDto activityDto) {
		return this.modelMapper.map(activityDto, ActivityEntity.class);
	}

	private ActivityDto activityToDto(ActivityEntity activity) {
		return this.modelMapper.map(activity, ActivityDto.class);
	}

	@Override
	public ActivityDto addActivity(ActivityDto activity) {
		ActivityEntity newActivity = dtoToActivity(activity);
		newActivity.setDate(LocalDateTime.now());
		ActivityEntity savedActivity = activityRepo.save(newActivity);
		return activityToDto(savedActivity);
	}

	@Override
	public ActivityDto updateActivity(Long id, ActivityDto activity) {
		ActivityEntity activityById = activityRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Activity", "activityId", id));

		if (activityById != null) {
			ActivityEntity upateActivity = dtoToActivity(activity);
			activityById.setActivityName(upateActivity.getActivityName());
			activityById.setActivityStats(upateActivity.getActivityStats());
			activityById.setActivityType(upateActivity.getActivityType());
			return activityToDto(activityRepo.save(activityById));
		}
		return null;
	}

	@Override
	public List<ActivityDto> getAllActivities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ActivityDto> getAllActivitiesByUser(Long userId) {
		List<ActivityEntity> allActivitiesByUserId = activityRepo.findAllByUserId(userId);
		List<ActivityDto> activityList = new ArrayList<>();
		allActivitiesByUserId.forEach(a -> {
			activityList.add(activityToDto(a));
		});
		return activityList;
	}

	@Override
	public ActivityDto getActivityById(Long id) {
		ActivityEntity activityById = activityRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Activity", "activityId", id));
		return activityToDto(activityById);
	}

	@Override
	public List<ActivityDto> getActivityByType(String type) {
		List<ActivityEntity> allActivitiesByType = activityRepo.findAllByActivityType(getActivityType(type));
		List<ActivityDto> activityList = new ArrayList<>();
		allActivitiesByType.forEach(a -> {
			activityList.add(activityToDto(a));
		});
		return activityList;
	}

	@Override
	public void deleteActivity(Long id) {
		ActivityEntity activity = activityRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Activity", "activityId", id));
		activityRepo.delete(activity);
	}

	public static ActivityTypeEnum getActivityType(String input) {
		switch (input) {
		case "Duration":
			return ActivityTypeEnum.Duration;
		case "WeightAndDistance":
			return ActivityTypeEnum.WeightAndDistance;
		case "WeightAndeReps":
			return ActivityTypeEnum.WeightAndeReps;
		case "DistanceAndDuration":
			return ActivityTypeEnum.DistanceAndDuration;
		default:
			throw new IllegalArgumentException("Unknown activity type: " + input);
		}
	}

}
