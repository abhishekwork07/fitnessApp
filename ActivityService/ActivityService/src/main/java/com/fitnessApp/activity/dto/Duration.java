package com.fitnessApp.activity.dto;

public class Duration {

	private String timeUnit;

	private Float time;

	public String getUnit() {
		return timeUnit;
	}

	public void setUnit(String unit) {
		this.timeUnit = unit;
	}

	public Float getTime() {
		return time;
	}

	public void setTime(Float time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Duration [unit=" + timeUnit + ", time=" + time + "]";
	}

}
