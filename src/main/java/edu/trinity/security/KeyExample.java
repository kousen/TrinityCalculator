package edu.trinity.security;

import java.security.*;
import javax.crypto.*;

public class KeyExample {

    public static void main(String[] args) throws Exception {
        // Generate key pair
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair keyPair = keyPairGen.generateKeyPair();

        // Encrypt
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        byte[] encryptedData = cipher.doFinal("Hello World".getBytes());

        // Decrypt
        cipher.init(Cipher.DECRYPT_MODE, keyPair.getPrivate());
        byte[] decryptedData = cipher.doFinal(encryptedData);
        System.out.println(new String(decryptedData));  // Outputs: Hello World
    }
}
