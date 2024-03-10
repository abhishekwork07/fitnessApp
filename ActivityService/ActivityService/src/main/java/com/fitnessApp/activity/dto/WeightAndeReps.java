package com.fitnessApp.activity.dto;

public class WeightAndeReps {

	private String weightUnit;

	private Float weight;

	private Integer repCount;

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

	public Integer getRepCount() {
		return repCount;
	}

	public void setRepCount(Integer repCount) {
		this.repCount = repCount;
	}

	@Override
	public String toString() {
		return "WeightAndeReps [weightUnit=" + weightUnit + ", weight=" + weight + ", repCount=" + repCount + "]";
	}

}
