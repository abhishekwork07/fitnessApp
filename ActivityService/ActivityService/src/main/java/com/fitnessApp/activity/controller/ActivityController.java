package com.fitnessApp.activity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fitnessApp.activity.dto.ActivityDto;
import com.fitnessApp.activity.service.ActivityService;

@RestController
@RequestMapping("/api/activity")
public class ActivityController {

	@Autowired
	private ActivityService service;

	@PostMapping("/add")
	public ResponseEntity<ActivityDto> addActivity(@RequestBody ActivityDto activity) {

		ActivityDto newActivity = service.addActivity(activity);
		return new ResponseEntity<>(newActivity, HttpStatus.CREATED);
	}

	@GetMapping("/{activityId}")
	public ResponseEntity<ActivityDto> getActivity(@PathVariable("activityId") Long activityId) {

		ActivityDto newActivity = service.getActivityById(activityId);
		return new ResponseEntity<>(newActivity, HttpStatus.OK);
	}

	@PutMapping("/update/{activityId}")
	public ResponseEntity<ActivityDto> updateActivity(@PathVariable("activityId") Long activityId,
			@RequestBody ActivityDto activity) {

		ActivityDto newActivity = service.updateActivity(activityId, activity);
		return new ResponseEntity<>(newActivity, HttpStatus.OK);
	}

	@DeleteMapping("/delete/{activityId}")
	public ResponseEntity<String> deleteActivity(@PathVariable("activityId") Long activityId) {

		service.deleteActivity(activityId);
		return new ResponseEntity<>("User deleted successfully", HttpStatus.OK);
	}

	@GetMapping("user/{userId}")
	public ResponseEntity<List<ActivityDto>> getActivityByUser(@PathVariable("userId") Long userId) {

		List<ActivityDto> allActivitiesByUser = service.getAllActivitiesByUser(userId);
		return new ResponseEntity<>(allActivitiesByUser, HttpStatus.OK);
	}

	@GetMapping("type/{activityType}")
	public ResponseEntity<List<ActivityDto>> getActivityByType(@PathVariable("activityType") String activityType) {

		List<ActivityDto> allActivitiesByType = service.getActivityByType(activityType);
		return new ResponseEntity<>(allActivitiesByType, HttpStatus.OK);
	}

}
