package com.fitnessApp.activity.dto;

public class DistanceAndDuration extends Duration {

	private String distanceUnit;

	private Float distance;

	public String getDistanceUnit() {
		return distanceUnit;
	}

	public void setDistanceUnit(String distanceUnit) {
		this.distanceUnit = distanceUnit;
	}

	public Float getDistance() {
		return distance;
	}

	public void setDistance(Float distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		return "DistanceAndDuration [distanceUnit=" + distanceUnit + ", distance=" + distance + "]";
	}

}
