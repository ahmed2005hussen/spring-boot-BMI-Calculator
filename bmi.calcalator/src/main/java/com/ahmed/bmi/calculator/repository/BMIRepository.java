package com.ahmed.bmi.calculator.repository;

import com.ahmed.bmi.calculator.entity.BMIRecord;
import org.springframework.data.repository.CrudRepository;

public interface BMIRepository extends CrudRepository<BMIRecord, Long> {
}
