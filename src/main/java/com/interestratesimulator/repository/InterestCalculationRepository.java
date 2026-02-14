package com.interestratesimulator.repository;

import com.interestratesimulator.entity.InterestCalculation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestCalculationRepository extends JpaRepository<InterestCalculation, Long> {
}
