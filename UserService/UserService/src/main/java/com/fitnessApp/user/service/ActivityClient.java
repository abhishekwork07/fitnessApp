package com.fitnessApp.user.service;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ACTIVITY-SERVICE")
public interface ActivityClient {

}
