package edu.trinity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LazySupplierTest {

    private String getErrorMessage() {
        System.out.println("getErrorMessage() called");
        return "error message";
    }

    @Test
    void eagerTest() {
        boolean x = true;
        assertTrue(x, getErrorMessage());
        assertTrue(x, () -> getErrorMessage());
    }
}
