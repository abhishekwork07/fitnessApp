package com.fitnessApp.activity.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fitnessApp.activity.entity.ActivityEntity;
import com.fitnessApp.activity.repo.ActivityRepository;
import com.fitnessApp.activity.util.ActivitySummaryPeriodEnum;
import com.fitnessApp.activity.util.ActivityUtils;

@Service
public class ActivitySummaryService {

	@Autowired
	private ActivityRepository activityRepo;

	@Autowired
	private ActivityUtils activityUtils;

	// Method to get daily summary for a specific user
	public List<ActivityEntity> getDailySummary(Long userId) {
		return activityRepo.findByUserIdAndDateBetween(userId, LocalDateTime.now(),
				activityUtils.getDatePreviousToCurrent(ActivitySummaryPeriodEnum.DAY));
	}

	// Method to get weekly summary for a specific user
	public List<ActivityEntity> getWeeklySummary(Long userId) {
		return activityRepo.findByUserIdAndDateBetween(userId, LocalDateTime.now(),
				activityUtils.getDatePreviousToCurrent(ActivitySummaryPeriodEnum.WEEK));
	}

	// Method to get monthly summary for a specific user
	public List<ActivityEntity> getMonthlySummary(Long userId) {
		return activityRepo.findByUserIdAndDateBetween(userId, LocalDateTime.now(),
				activityUtils.getDatePreviousToCurrent(ActivitySummaryPeriodEnum.MONTH));
	}

}
