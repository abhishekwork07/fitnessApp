package com.fitnessApp.activity.dto;

public class WeightAndDistance {

	private String weightUnit;

	private Float weight;

	private String distanceUnit;

	private Float distance;

	public String getWeightUnit() {
		return weightUnit;
	}

	public void setWeightUnit(String weightUnit) {
		this.weightUnit = weightUnit;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

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
		return "WeightAndDistance [weightUnit=" + weightUnit + ", weight=" + weight + ", distanceUnit=" + distanceUnit
				+ ", distance=" + distance + "]";
	}

}
