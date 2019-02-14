package com.botany.mint.exercise;

import java.util.concurrent.TimeUnit;

/**
 * @author wangzh
 */
public class ThreadTest {

    private static boolean stopRequested;

    public synchronized static boolean isStopRequested() {
        return stopRequested;
    }

    public synchronized static void setStopRequested(boolean stopRequested) {
        ThreadTest.stopRequested = stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(() -> {
            int i = 0;
            while (!isStopRequested()) {
                i++;
                System.out.println(i);
            }

        });
        thread1.start();

        TimeUnit.SECONDS.sleep(1);
        setStopRequested(true);
    }
}
