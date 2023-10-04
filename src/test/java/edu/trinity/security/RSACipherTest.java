package edu.trinity.security;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RSACipherTest {
    @Test
    public void testEncryptionDecryption() {
        try {
            RSACipher rsaCipher = new RSACipher();
            String originalText = "Hello World";

            byte[] encryptedData = rsaCipher.encryptData(originalText);

            // Ensure that the encrypted data is not the same as the original text
            String encryptedText = new String(encryptedData);
            assertNotEquals(originalText, encryptedText);

            String decryptedData = rsaCipher.decryptData(encryptedData);

            // Ensure that the decrypted data is the same as the original text
            assertEquals(originalText, decryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}