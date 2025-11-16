package com.example.atm.util;

import java.util.Random;

public class PinGenerator {
    public static String generatePin() {
        Random rand = new Random();
        int pin = 1000 + rand.nextInt(9000);
        return String.valueOf(pin);
    }
}
