package edu.trinity.security;

import org.junit.jupiter.api.Test;

import java.security.KeyPair;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DigitalSignatureUtilsTest {

    @Test
    public void shouldVerifySignature() throws Exception {
        DigitalSignatureUtils signatureExample = new DigitalSignatureUtils();
        KeyPair keyPair = signatureExample.generateKeyPair();
        byte[] message = "Hello World".getBytes();

        byte[] digitalSignature = signatureExample.signData(message, keyPair.getPrivate());
        boolean isVerified = signatureExample.verifySignature(message, digitalSignature, keyPair.getPublic());

        assertTrue(isVerified);
    }

}