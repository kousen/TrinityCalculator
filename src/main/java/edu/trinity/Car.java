package edu.trinity;

import java.time.Year;

public class Car {

    private final String MAKE;
    private final String MODEL;
    private final Year YEAR;
    private boolean isRunning;
    private int miles;

    public Car(String make, String model, Year year) {
        MAKE = make;
        MODEL = model;
        YEAR = year;
        isRunning = false;
    }

    public String getMake() {
        return MAKE;
    }

    public String getModel() {
        return MODEL;
    }

    public Year getYear() {
        return YEAR;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void start() {
        isRunning = true;
    }

    public void stop() {
        isRunning = false;
    }

    public void drive(int distance) {
        if (isRunning)
            miles += distance;
    }

    public int getMiles() {
        return miles;
    }
}
