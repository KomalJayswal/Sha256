# Sha256

The SHA (Secure Hash Algorithm) is one of the popular cryptographic hash functions.
A cryptographic hash can be used to make a signature for a text or a data file.
The SHA-256 algorithm generates an almost unique, fixed-size 256-bit (32-byte) hash.
This is a one-way function, so the result cannot be decrypted back to the original value.
Currently, SHA-2 hashing is widely used, as it is considered the most secure hashing algorithm in the cryptographic arena.
SHA-3 is the latest secure hashing standard after SHA-2.
Compared to SHA-2, SHA-3 provides a different approach to generate a unique one-way hash, and it can be much faster on some hardware implementations.
Similar to SHA-256, SHA3-256 is the 256-bit fixed-length algorithm in SHA-3.

## Problem Statement

How we can perform SHA-256 and SHA3-256 hashing operations using various Java libraries.

## Getting Started With Solution
1. Build a fresh springboot Application using Spring Initializer.
2. Execute `mvn clean install`

### a. MessageDigest Class in Java

1. Create `MessageDigestAlgo.class`
```bash
mport java.nio.charset.StandardCharsets;
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
```
2. Now run the `MessageDigestAlgo.class`

<u>OUTPUT</u>
```bash
Password : password
Encoded Hash : [B@5ce65a89
Encoded Hash in Hexadecimal : 5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8 
```
### b. Guava Library

1. Add Java Dependency
```bash
<dependency>
    <groupId>com.google.guava</groupId>
    <artifactId>guava</artifactId>
    <version>31.0.1-jre</version>
</dependency>
```
2. Execute mvn clean install
3. Create `GuavaLibrary.class`
```bash 
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
```
4. Run the `GuavaLibrary.class`

<u>OUTPUT</u>
```bash
Password : password
Encoded Hash : 5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8
```

### c. Apache Commons Codecs

1. Add Java Dependency
```bash
<dependency>
    <groupId>commons-codec</groupId>
    <artifactId>commons-codec</artifactId>
    <version>1.11</version>
</dependency>
```
2. Execute mvn clean install
3. Create `ApacheCommonsCodecs.class`
```bash 
import org.apache.commons.codec.digest.DigestUtils;
public class ApacheCommonsCodecs {
    public static void main(String[] args) {
        String password = "password";
        System.out.println("Password : " + password);
        String sha256hex = DigestUtils.sha256Hex(password);
        System.out.println("Encoded Hash : "+sha256hex);
    }
}
```
4. Run the `ApacheCommonsCodecs.class`

<u>OUTPUT</u>
```bash
Password : password
Encoded Hash : 5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8
```

## Reference

[sha 256 hashing java](https://www.baeldung.com/sha-256-hashing-java)
