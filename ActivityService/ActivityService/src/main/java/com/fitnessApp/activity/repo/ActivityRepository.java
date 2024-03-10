package com.fitnessApp.activity.repo;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fitnessApp.activity.entity.ActivityEntity;
import com.fitnessApp.activity.util.ActivityTypeEnum;

public interface ActivityRepository extends JpaRepository<ActivityEntity, Long> {

	List<ActivityEntity> findAllByUserId(Long userId);

	List<ActivityEntity> findAllByActivityType(ActivityTypeEnum activityType);

	List<ActivityEntity> findByUserIdAndDateBetween(Long userId, LocalDateTime startDate, LocalDateTime endDate);

}
