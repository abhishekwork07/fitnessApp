package com.fitnessApp.activity.util;

import java.time.LocalDateTime;

import org.springframework.stereotype.Component;

@Component
public class ActivityUtils {

	public LocalDateTime getDatePreviousToCurrent(ActivitySummaryPeriodEnum period) {
		LocalDateTime currentDate = LocalDateTime.now();

		switch (period) {
		case DAY:
			return currentDate.minusDays(1);
		case WEEK:
			return currentDate.minusWeeks(1);
		case MONTH:
			return currentDate.minusMonths(1);
		default:
			throw new IllegalArgumentException("Invalid period: " + period);
		}
	}

}
