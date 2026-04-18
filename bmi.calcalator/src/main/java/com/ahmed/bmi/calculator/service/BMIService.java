package com.ahmed.bmi.calculator.service;

import com.ahmed.bmi.calculator.dto.BMIRequest;
import com.ahmed.bmi.calculator.entity.BMIRecord;

public interface BMIService {

    public Iterable<BMIRecord> findAll();

    public void deleteById(Long id);

    public Double calcBMI(BMIRequest bmiRequest);

    public void saveBMIRecord(BMIRequest bmiRequest , Double BMI);

}
