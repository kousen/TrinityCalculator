package edu.trinity.security;

public class CaesarCipher {

    private final int shift;

    public CaesarCipher(int shift) {
        this.shift = shift % 26;  // Ensure shift is within the range [0, 25]
    }

    public String encrypt(String plaintext) {
        return processText(plaintext, shift);
    }

    public String decrypt(String ciphertext) {
        return processText(ciphertext, 26 - shift);
    }

    private String processText(String text, int shiftValue) {
        StringBuilder result = new StringBuilder();

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                char encryptedChar = (char) ((ch - base + shiftValue) % 26 + base);
                result.append(encryptedChar);
            } else {
                result.append(ch);  // Non-letter characters remain unchanged
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        CaesarCipher cipher = new CaesarCipher(3);
        String encrypted = cipher.encrypt("Hello, World!");
        System.out.println(encrypted);  // Outputs: Khoor, Zruog!
        String decrypted = cipher.decrypt(encrypted);
        System.out.println(decrypted);  // Outputs: Hello, World!
    }
}
