package edu.trinity.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SqlInjectionExampleTest {
    private final SqlInjectionExample example = new SqlInjectionExample();

    @Test
    void testLoginSuccess() throws Exception {
        assertTrue(example.login("admin", "pass123"));
    }

    @Test
    void testLoginFail() throws Exception {
        assertFalse(example.login("admin", "wrongpassword"));
    }

    @Test
    void testSqlInjectionAttack() throws Exception {
        assertTrue(example.login("admin", "' OR '1'='1'; -- "));
    }

}