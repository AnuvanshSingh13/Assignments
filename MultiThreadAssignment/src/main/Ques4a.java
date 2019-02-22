package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ques4a { //Try shutdown() and shutdownNow() and observe the difference.
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        try {
            executorService.submit(() -> System.out.println("Thread 1"));
            executorService.submit(() -> System.out.println("Thread 2"));
            executorService.submit(() -> {
                try {
                    Thread.sleep(3000L); //intrrupt will occur due to shutdownNow
                    System.out.println("Thread 3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            });
        } finally {
            executorService.shutdownNow();

        }
        System.out.println(executorService.isShutdown());
        System.out.println(executorService.isTerminated());
        System.out.println("ShutDownNow Program");
    }
}
