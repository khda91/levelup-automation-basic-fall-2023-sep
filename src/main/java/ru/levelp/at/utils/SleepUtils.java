package ru.levelp.at.utils;

import java.util.concurrent.TimeUnit;

public final class SleepUtils {

    public static void sleep(long timeoutMills) {
        try {
            TimeUnit.MILLISECONDS.sleep(timeoutMills);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private SleepUtils() {

    }
}
