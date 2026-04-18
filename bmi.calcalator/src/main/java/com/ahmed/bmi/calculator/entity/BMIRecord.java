package com.ahmed.bmi.calculator.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

@Entity
public class BMIRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;

    @NotNull(message = "Weight can not be null ! ")
    private Double weight ;

    @NotNull(message = "Height can not be null ! ")
    private Double height ;

    private Double BMI ;

    private String category ;

    private Boolean isMetric;

    public BMIRecord() {}

    public BMIRecord(Double weight, Double height, Double BMI, String category) {
        this.weight = weight;
        this.height = height;
        this.BMI = BMI;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Double getBMI() {
        return BMI;
    }

    public void setBMI(Double BMI) {
        this.BMI = BMI;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Boolean getMetric() {
        return isMetric;
    }

    public void setMetric(Boolean metric) {
        isMetric = metric;
    }

    @Override
    public String toString() {
        return "BMIRecord{" +
                "id=" + id +
                ", weight=" + weight +
                ", height=" + height +
                ", BMI=" + BMI +
                ", category='" + category + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        BMIRecord bmiRecord = (BMIRecord) o;
        return Objects.equals(id, bmiRecord.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
