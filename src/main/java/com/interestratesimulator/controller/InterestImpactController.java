package com.interestratesimulator.controller;

import com.interestratesimulator.model.InterestRequest;
import com.interestratesimulator.model.InterestResponse;
import com.interestratesimulator.service.InterestImpactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/interest-impact")
public class InterestImpactController {

    private final InterestImpactService interestImpactService;

    @Autowired
    public InterestImpactController(InterestImpactService interestImpactService) {
        this.interestImpactService = interestImpactService;
    }

    @PostMapping("/calculate")
    public ResponseEntity<?> calculateImpact(@RequestBody InterestRequest request) {
        if (request.getPrincipal() <= 0 || request.getYears() <= 0 || request.getCurrentRate() < 0
                || request.getNewRate() < 0) {
            return ResponseEntity.badRequest().body("Invalid input parameters.");
        }

        InterestResponse response = interestImpactService.calculateImpact(request);
        return ResponseEntity.ok(response);
    }
}
