package io.github.makbn.utils;

import java.util.Random;

/**
 * Mehdi AKbarian-astaghi 8/11/19
 */
public class NumberUtils {

    private static Random random = new Random();


    public static String GenerateRandomNumber(int charLength) {
        return String.valueOf(charLength < 1 ? 0 : random
                .nextInt((9 * (int) Math.pow(10, charLength - 1)) - 1)
                + (int) Math.pow(10, charLength - 1));
    }
}
