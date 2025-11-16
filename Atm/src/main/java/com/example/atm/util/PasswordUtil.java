package com.example.atm.util;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordUtil {
    private static final SecureRandom RAND = new SecureRandom();

    public static String hashPin(String pin) {
        byte[] salt = new byte[16];
        RAND.nextBytes(salt);
        byte[] hash = sha256(pin, salt);
        return Base64.getEncoder().encodeToString(salt) + ":" + Base64.getEncoder().encodeToString(hash);
    }

    public static boolean verifyPin(String pin, String stored) {
        try {
            String[] parts = stored.split(":");
            if(parts.length != 2) return false;
            byte[] salt = Base64.getDecoder().decode(parts[0]);
            byte[] hash = Base64.getDecoder().decode(parts[1]);
            byte[] computed = sha256(pin, salt);
            int diff = 0;
            for(int i=0;i<hash.length;i++) diff |= hash[i] ^ computed[i];
            return diff==0;
        } catch(Exception e) {
            return false;
        }
    }

    private static byte[] sha256(String pin, byte[] salt) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(salt);
            return md.digest(pin.getBytes(StandardCharsets.UTF_8));
        } catch(Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
