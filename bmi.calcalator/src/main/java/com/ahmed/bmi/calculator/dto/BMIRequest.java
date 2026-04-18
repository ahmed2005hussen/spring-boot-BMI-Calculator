package com.ahmed.bmi.calculator.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class BMIRequest {

    @NotNull(message = "Weight is required")
    @Positive(message = "Weight must be positive")
    private Double weight ;

    @NotNull(message = "Height is required")
    @Positive(message = "Height must be positive")
    private Double height ;

    @NotNull(message = "Please specify metric or imperial")
    private Boolean isMetric;

    public BMIRequest() {}

    public BMIRequest(Double weight, Double height) {
        this.weight = weight;
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Boolean getMetric() {
        return isMetric;
    }

    public void setMetric(Boolean metric) {
        isMetric = metric;
    }
}
