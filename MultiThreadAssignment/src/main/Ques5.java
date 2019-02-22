package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ques5 {
    /*Use isShutDown() and isTerminate() with ExecutorService.*/

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            executorService.submit(() -> System.out.println("Thread 1"));
            executorService.submit(() -> System.out.println("Thread 2"));
            executorService.submit(() -> {
                try {
                    Thread.sleep(3000L);
                    System.out.println("Thread 3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        } finally {
            executorService.shutdownNow();
        }

        System.out.println("\nis ExecutorService shutdown? " + executorService.isShutdown());
        System.out.println("is ExecutorService terminated? " + executorService.isTerminated());
        System.out.println("End");
    }
}
