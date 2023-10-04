package edu.trinity.security;

import net.jqwik.api.ForAll;
import net.jqwik.api.Label;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.AlphaChars;
import net.jqwik.api.constraints.IntRange;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Label("CaesarCipher Property-based Test")
class CaesarCipherPropertiesTest {


    // Printable ASCII characters:
    // The character range specified by @CharRange(min = ' ', max = '~')
    // corresponds to the range of printable ASCII characters.
    //
    // In the ASCII table:
    // The character ' ' (space) is the first printable character,
    //      with a decimal value of 32.
    // The character '~' (tilde) is the last printable character
    //      in the ASCII range, with a decimal value of 126.
    @Property
    @Label("Encrypting and then Decrypting returns the original text")
    void testEncryptDecrypt(
            @ForAll @AlphaChars String text,
            @ForAll @IntRange(min = 1, max = 25) int shift
    ) {
        CaesarCipher cipher = new CaesarCipher(shift);
        String encrypted = cipher.encrypt(text);
        String decrypted = cipher.decrypt(encrypted);
        assertEquals(text, decrypted);
    }

}
