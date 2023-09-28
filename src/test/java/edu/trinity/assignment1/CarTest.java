package edu.trinity.assignment1;

import org.junit.jupiter.api.Test;

import java.time.Year;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {
    private final Car car = new Car("Toyota",
            "Camry", Year.of(2023));

    @Test
    void testGetters() {
        assertAll(
                () -> assertEquals("Toyota", car.getMake()),
                () -> assertEquals("Camry", car.getModel()),
                () -> assertEquals(Year.of(2023), car.getYear())
        );
    }

    @Test
    void start() {
        assertFalse(car.isRunning());
        car.start();
        assertTrue(car.isRunning());
    }

    @Test
    void stop() {
        car.start();
        assertTrue(car.isRunning());
        car.stop();
        assertFalse(car.isRunning());
    }

    @Test
    void drive() {
        car.start();
        car.drive(10);
        assertEquals(10, car.getMiles());
        car.drive(5);
        assertEquals(15, car.getMiles());
        car.stop();
        car.drive(10);
        assertEquals(15, car.getMiles());
    }
}