package edu.trinity.security;

import org.junit.jupiter.api.Test;

import java.security.NoSuchAlgorithmException;

import static org.junit.jupiter.api.Assertions.*;

class MessageHashingServiceTest {
    private static final String INPUT_MESSAGE = "Hello World";

    @Test
    public void testCalculateHash() {
        MessageHashingService service = new MessageHashingService();
        try {
            byte[] hash = service.calculateHash(INPUT_MESSAGE);
            assertNotNull(hash);
            System.out.println(service.bytesToHex(hash));  // Outputs: hash in hex
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}