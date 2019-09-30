package com.company.Infrastructure.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StdTestLogger implements TestLogger {
    private int step = 1;

    @Override  // на самом деле он имплементирует поведение
    public void log(String msg) {
        msg = step + ") " + currentTimeStamp() + " [" + currentMethod() + "]: " + msg;
        step++;

        System.out.println(msg);
    }

    private String currentTimeStamp() {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS");
        return sdf.format(new Date());
    }

    private String currentMethod() {
        return Thread.currentThread().getName();
    }
}
