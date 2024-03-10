package com.fitnessApp.activity.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fitnessApp.activity.entity.ActivityEntity;
import com.fitnessApp.activity.service.ActivitySummaryService;

@RestController
@RequestMapping("/api/activity/summary")
public class ActivitySummaryController {

	@Autowired
	ActivitySummaryService summaryService;

	@GetMapping("/daily")
	public List<ActivityEntity> getDailySummary(@RequestParam Long userId) {
		return summaryService.getDailySummary(userId);
	}

	@GetMapping("/weekly")
	public List<ActivityEntity> getWeeklySummary(@RequestParam Long userId) {
		return summaryService.getWeeklySummary(userId);
	}

	@GetMapping("/monthly")
	public List<ActivityEntity> getMonthlySummary(@RequestParam Long userId) {
		return summaryService.getMonthlySummary(userId);
	}


}
