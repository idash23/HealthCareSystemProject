package edu.okcu.healthcaresystem.models;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Hash {

    public String getHash(String passwordToHash, boolean withSalt) throws NoSuchAlgorithmException {
        String generatedPassword;
        // https://docs.oracle.com/javase/7/docs/technotes/guides/security/StandardNames.html#MessageDigest
        MessageDigest md = MessageDigest.getInstance("SHA-512");

        if (withSalt) {
            byte[] saltValue = getSalt();
            md.update(saltValue);
        }

        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();

        for (byte aByte : bytes) {
            sb.append(String.format("%02x", aByte));
        }

        generatedPassword = sb.toString();

        return generatedPassword;
    }

    public byte[] getSalt() throws NoSuchAlgorithmException {
        // https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html#SecureRandom
        SecureRandom random = SecureRandom.getInstance("SHA1PRNG");
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return salt;
    }

    public String byteToString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte aByte : bytes) {
            sb.append(String.format("%02x", aByte));
        }
        return sb.toString();
    }

}
