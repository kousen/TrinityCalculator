package edu.trinity.optional;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    private final Manager bart = new Manager("Bart", "J", "Simpson");
    private final Manager lisa = new Manager("Lisa", null, "Simpson");

    @Test
    void getMiddleName() {
        assertTrue(bart.getMiddle().isPresent());
        assertAll(
                () -> assertEquals("J", bart.getMiddle().get()),
                () -> assertTrue(lisa.getMiddle().isEmpty())
        );
    }

}