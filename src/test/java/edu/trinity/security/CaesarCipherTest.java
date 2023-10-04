package edu.trinity.security;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CaesarCipherTest {

    @Test
    public void testEncryption() {
        CaesarCipher cipher = new CaesarCipher(3);
        String encrypted = cipher.encrypt("Hello, World!");
        assertEquals("Khoor, Zruog!", encrypted);
    }

    @Test
    public void testDecryption() {
        CaesarCipher cipher = new CaesarCipher(3);
        String decrypted = cipher.decrypt("Khoor, Zruog!");
        assertEquals("Hello, World!", decrypted);
    }

    @Test
    public void testEncryptDecrypt() {
        CaesarCipher cipher = new CaesarCipher(3);
        String original = "Java 17 is cool!";
        String encrypted = cipher.encrypt(original);
        String decrypted = cipher.decrypt(encrypted);
        assertEquals(original, decrypted);
    }

    @Test
    public void testShiftWrapAround() {
        CaesarCipher cipher = new CaesarCipher(25);
        String encrypted = cipher.encrypt("abc");
        assertEquals("zab", encrypted);

        String decrypted = cipher.decrypt(encrypted);
        assertEquals("abc", decrypted);
    }
}
