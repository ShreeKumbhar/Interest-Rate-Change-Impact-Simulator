package com.interestratesimulator.model;

public class InterestRequest {

    private double principal;
    private double currentRate;
    private double newRate;
    private int years;

    public InterestRequest() {
    }

    public InterestRequest(double principal, double currentRate, double newRate, int years) {
        this.principal = principal;
        this.currentRate = currentRate;
        this.newRate = newRate;
        this.years = years;
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
}
