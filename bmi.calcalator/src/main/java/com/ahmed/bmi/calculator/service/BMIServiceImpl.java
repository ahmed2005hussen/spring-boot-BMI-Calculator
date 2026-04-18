package com.ahmed.bmi.calculator.service;

import com.ahmed.bmi.calculator.dto.BMIRequest;
import com.ahmed.bmi.calculator.entity.BMIRecord;
import com.ahmed.bmi.calculator.repository.BMIRepository;
import org.springframework.stereotype.Service;

@Service
public class BMIServiceImpl implements BMIService {

    private final BMIRepository bmiRepository;

    public BMIServiceImpl(BMIRepository bmiRepository) {
        this.bmiRepository = bmiRepository;
    }

    @Override
    public Iterable<BMIRecord> findAll() {
        return bmiRepository.findAll();
    }

    private BMIRecord save(BMIRecord bmiRecord) {
        return bmiRepository.save(bmiRecord);
    }

    @Override
    public void deleteById(Long id) {
        bmiRepository.deleteById(id);
    }

    @Override
    public Double calcBMI(BMIRequest bmiRequest) {

        Double weight = bmiRequest.getWeight();
        Double height = bmiRequest.getHeight() * bmiRequest.getHeight();
        Double BMI = weight / height;
        if (Boolean.FALSE.equals(bmiRequest.getMetric())) {
            BMI *= 703;
        }
        saveBMIRecord(bmiRequest , BMI);

        return BMI;
    }

    @Override
    public void saveBMIRecord(BMIRequest bmiRequest, Double BMI) {
        BMIRecord bmiRecord = new BMIRecord();
        bmiRecord.setBMI(BMI);
        bmiRecord.setHeight(bmiRequest.getHeight());
        bmiRecord.setWeight(bmiRequest.getWeight());
        bmiRecord.setMetric(bmiRequest.getMetric());

        String category = "";

        if (BMI < 18.5) {
            category = "Underweight";
        } else if (BMI >= 18.5 && BMI <= 24.9) {
            category = "Normal weight";
        } else if (BMI >= 25 && BMI <= 29.9) {
            category = "Overweight";
        } else if (BMI >= 30) {
            category = "Obese";
        }

        bmiRecord.setCategory(category);
        save(bmiRecord);
    }

}
