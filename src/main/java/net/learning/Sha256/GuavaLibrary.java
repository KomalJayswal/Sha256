package net.learning.Sha256;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;
public class GuavaLibrary {
    public static void main(String[] args) {

        String password = "password";
        System.out.println("Password : "+password);
        String sha256hex = Hashing.sha256().hashString(password, StandardCharsets.UTF_8).toString();
        System.out.println("Encoded Hash : "+sha256hex);
    }
}
