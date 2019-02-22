package main;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ques9 {
    //Increase concurrency with Thread pools using newCachedThreadPool() and newFixedThreadPool().
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newCachedThreadPool();

        for (int i = 0; i <= 10; i++) {
            executorService.submit(new Process(i));
        }
        executorService.shutdown();
    }
}
class Process implements Runnable{
    int id;

    public Process(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Thread name::"+Thread.currentThread().getName()+" Start :"+id);
        try {
            Thread.sleep(2000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread name::"+Thread.currentThread().getName()+" End :"+id);
    }
}