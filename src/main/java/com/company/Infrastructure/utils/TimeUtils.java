package com.company.Infrastructure.utils;

public class TimeUtils {

    public static void wait(int seconds) {

        try {
            Thread.sleep(seconds);
        } catch (InterruptedException ex) {
            throw new RuntimeException("Oops... something went wrong");
        }
    }
}
