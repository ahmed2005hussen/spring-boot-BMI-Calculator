package com.ahmed.bmi.calculator.controllers;

import com.ahmed.bmi.calculator.dto.BMIRequest;
import com.ahmed.bmi.calculator.entity.BMIRecord;
import com.ahmed.bmi.calculator.service.BMIService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/BMI")
public class BMIController {

    private final BMIService bmiService;

    public BMIController(BMIService bmiService) {
        this.bmiService = bmiService;
    }

    @PostMapping("/calc")
    public double calculate(@RequestBody BMIRequest bmiRequest) {

        double BMI = bmiService.calcBMI(bmiRequest);
        return BMI;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        bmiService.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/allBMI")
    public Iterable<BMIRecord> allRecords() {
        return bmiService.findAll();
    }
}
