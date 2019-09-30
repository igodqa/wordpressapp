package com.company.Infrastructure.utils;

public class MathUtils {
    public static int randomFromRange(int min, int max) {
        if (min == max)
            return min;
        if (min > max)
            throw new RuntimeException("Range was set incorrectly");

        return min + (int) (Math.random() * (max - min)) + 1;
    }
}
