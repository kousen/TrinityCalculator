package edu.trinity.security;

import java.security.*;

public class DigitalSignatureUtils {

    private static final String RSA = "RSA";
    private static final String SHA256WithRSA = "SHA256withRSA";
    private static final int KEY_SIZE = 2048;

    public KeyPair generateKeyPair() throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance(RSA);
        keyPairGen.initialize(KEY_SIZE);
        return keyPairGen.generateKeyPair();
    }

    public byte[] signData(byte[] data, PrivateKey privateKey)
            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signature = Signature.getInstance(SHA256WithRSA);
        signature.initSign(privateKey);
        signature.update(data);
        return signature.sign();
    }

    public boolean verifySignature(byte[] data, byte[] digitalSignature, PublicKey publicKey)
            throws NoSuchAlgorithmException, InvalidKeyException, SignatureException {
        Signature signature = Signature.getInstance(SHA256WithRSA);
        signature.initVerify(publicKey);
        signature.update(data);
        return signature.verify(digitalSignature);
    }
}
