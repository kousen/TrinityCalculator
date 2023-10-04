package edu.trinity.security;

import java.security.*;

public class MessageHashingService {

    private static final String DIGEST_ALGORITHM_SHA256 = "SHA-256";

    public byte[] calculateHash(String message) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(DIGEST_ALGORITHM_SHA256);
        return md.digest(message.getBytes());
    }

    public String bytesToHex(byte[] bytes) {
        StringBuilder hexString = new StringBuilder(2 * bytes.length);
        for (byte aByte : bytes) {
            String hex = Integer.toHexString(0xff & aByte);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
