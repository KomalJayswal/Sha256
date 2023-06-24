package net.learning.Sha256;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

// MessageDigest is not thread-safe. Consequently, we should use a new instance for every thread.
public class MessageDigestAlgo {

    public static void main(String[] args) throws NoSuchAlgorithmException {

        String password = "password";

        System.out.println("Password : "+password);

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedhash = digest.digest(
                password.getBytes(StandardCharsets.UTF_8));
        System.out.println("Encoded Hash : "+encodedhash);

        System.out.println("Encoded Hash in Hexadecimal : "+bytesToHex(encodedhash));
    }

    private static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
