package edu.trinity.assignment1;

import java.time.Year;
import java.util.Objects;

public class Car {
    private final String make;
    private final String model;
    private final Year year;

    private double miles;
    private boolean running;

    public Car(String make, String model, Year year) {
        this.make = make;
        this.model = model;
        this.year = year;
    }

    public void start() {
        running = true;
    }

    public void stop() {
        running = false;
    }

    public void drive(double miles) {
        // Only increment miles if the car is running
        if (running) {
            this.miles += miles;
        }
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public Year getYear() {
        return year;
    }

    public double getMiles() {
        return miles;
    }

    public boolean isRunning() {
        return running;
    }

    // Two cars are equivalent if they have the same make, model, and year
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(make, car.make) &&
               Objects.equals(model, car.model) &&
               Objects.equals(year, car.year);
    }

    // Always override hashCode if you override equals
    // For consistency, only use make, model, and year to calculate the hash code
    @Override
    public int hashCode() {
        return Objects.hash(make, model, year);
    }

    @Override
    public String toString() {
        return "Car{" +
               "make='" + make + '\'' +
               ", model='" + model + '\'' +
               ", year=" + year +
               ", miles=" + miles +
               '}';
    }
}
