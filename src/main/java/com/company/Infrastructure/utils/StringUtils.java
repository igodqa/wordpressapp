package com.company.Infrastructure.utils;


import static com.company.Infrastructure.utils.MathUtils.randomFromRange;

public class StringUtils {

    public enum Mode {
        ALPHA,
        NUMERIC,
        ALPHANUMERIC
    }

    public static String randomString(Mode mode, int length) {
        String result = "";
        String alphabet;
        switch (mode) {
            case ALPHA:
                alphabet = "abcdefghijklmnoprstuvwxyz";
                break;
            case NUMERIC:
                alphabet = "0123456789";
                break;
            case ALPHANUMERIC:
                alphabet = "abcdefghijklmnoprstuvwxyz0123456789";
                break;
            default:
                throw new IllegalArgumentException("Such mode is not supported");
        }
        for (int i = 0; i < length; i++) {
            int randomIndex = randomFromRange(0, alphabet.length() - 1);
            result += alphabet.charAt(randomIndex);
        }
        return result;
    }
}
