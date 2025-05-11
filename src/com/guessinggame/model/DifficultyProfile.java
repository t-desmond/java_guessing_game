package com.guessinggame.model;

public class DifficultyProfile {
    private final String name;
    private final int maxNumber;
    private final int maxAttempts;

    public DifficultyProfile(String name, int maxNumber, int maxAttempts) {
        this.name = name;
        this.maxNumber = maxNumber;
        this.maxAttempts = maxAttempts;
    }

    public String getName() {
        return name;
    }

    public int getMaxNumber() {
        return maxNumber;
    }

    public int getMaxAttempts() {
        return maxAttempts;
    }
}
