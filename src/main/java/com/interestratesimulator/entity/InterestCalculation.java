package com.interestratesimulator.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "interest_calculations")
public class InterestCalculation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double principal;
    private double currentRate;
    private double newRate;
    private int years;
    private double oldMaturity;
    private double newMaturity;
    private double difference;

    private LocalDateTime createdAt;

    public InterestCalculation() {
        this.createdAt = LocalDateTime.now();
    }

    public InterestCalculation(double principal, double currentRate, double newRate, int years, double oldMaturity,
            double newMaturity, double difference) {
        this.principal = principal;
        this.currentRate = currentRate;
        this.newRate = newRate;
        this.years = years;
        this.oldMaturity = oldMaturity;
        this.newMaturity = newMaturity;
        this.difference = difference;
        this.createdAt = LocalDateTime.now();
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPrincipal() {
        return principal;
    }

    public void setPrincipal(double principal) {
        this.principal = principal;
    }

    public double getCurrentRate() {
        return currentRate;
    }

    public void setCurrentRate(double currentRate) {
        this.currentRate = currentRate;
    }

    public double getNewRate() {
        return newRate;
    }

    public void setNewRate(double newRate) {
        this.newRate = newRate;
    }

    public int getYears() {
        return years;
    }

    public void setYears(int years) {
        this.years = years;
    }

    public double getOldMaturity() {
        return oldMaturity;
    }

    public void setOldMaturity(double oldMaturity) {
        this.oldMaturity = oldMaturity;
    }

    public double getNewMaturity() {
        return newMaturity;
    }

    public void setNewMaturity(double newMaturity) {
        this.newMaturity = newMaturity;
    }

    public double getDifference() {
        return difference;
    }

    public void setDifference(double difference) {
        this.difference = difference;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
