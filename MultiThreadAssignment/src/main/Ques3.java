package main;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ques3 {
    //Use a singleThreadExecutor to submit multiple threads.
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        executorService.submit(() -> System.out.println("Thread1"));
        executorService.submit(() -> System.out.println("Thread2"));
        executorService.submit(() -> System.out.println("Thread3"));
        executorService.shutdown();
        System.out.println("Ending of Program");
    }
}
