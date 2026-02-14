package com.interestratesimulator.service;

import com.interestratesimulator.model.InterestRequest;
import com.interestratesimulator.model.InterestResponse;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Service
public class InterestImpactService {

    public InterestResponse calculateImpact(InterestRequest request) {
        double principal = request.getPrincipal();
        double currentRate = request.getCurrentRate();
        double newRate = request.getNewRate();
        int years = request.getYears();

        double oldMaturity = calculateCompoundInterest(principal, currentRate, years);
        double newMaturity = calculateCompoundInterest(principal, newRate, years);

        double difference = newMaturity - oldMaturity;

        // Rounding to 2 decimal places
        oldMaturity = round(oldMaturity);
        newMaturity = round(newMaturity);
        difference = round(difference);

        String message;
        if (difference > 0) {
            message = "Interest rate increase results in higher returns.";
        } else if (difference < 0) {
            message = "Interest rate decrease results in lower returns.";
        } else {
            message = "No impact due to rate change.";
        }

        return new InterestResponse(oldMaturity, newMaturity, difference, message);
    }

    private double calculateCompoundInterest(double principal, double rate, int years) {
        // A = P * (1 + r/100)^t
        return principal * Math.pow((1 + rate / 100), years);
    }

    private double round(double value) {
        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(2, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
