package com.interestratesimulator.model;

public class InterestResponse {

    private double oldMaturityAmount;
    private double newMaturityAmount;
    private double difference;
    private String message;

    public InterestResponse() {
    }

    public InterestResponse(double oldMaturityAmount, double newMaturityAmount, double difference, String message) {
        this.oldMaturityAmount = oldMaturityAmount;
        this.newMaturityAmount = newMaturityAmount;
        this.difference = difference;
        this.message = message;
    }

    public double getOldMaturityAmount() {
        return oldMaturityAmount;
    }

    public void setOldMaturityAmount(double oldMaturityAmount) {
        this.oldMaturityAmount = oldMaturityAmount;
    }

    public double getNewMaturityAmount() {
        return newMaturityAmount;
    }

    public void setNewMaturityAmount(double newMaturityAmount) {
        this.newMaturityAmount = newMaturityAmount;
    }

    public double getDifference() {
        return difference;
    }

    public void setDifference(double difference) {
        this.difference = difference;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
