package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ques4b {
    //Try shutdown() and shutdownNow() and observe the difference.
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            executorService.submit(() -> System.out.println("Thread 1"));
            executorService.submit(() -> System.out.println("Thread 2"));
            executorService.submit(() -> System.out.println("Thread 3"));
        } finally {
            executorService.shutdown();
        }

        System.out.println("ShutDown Example");
    }
}


