package net.learning.Sha256;

import org.apache.commons.codec.digest.DigestUtils;
public class ApacheCommonsCodecs {
    public static void main(String[] args) {
        String password = "password";
        System.out.println("Password : " + password);
        String sha256hex = DigestUtils.sha256Hex(password);
        System.out.println("Encoded Hash : "+sha256hex);
    }
}
