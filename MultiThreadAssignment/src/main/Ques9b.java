package main;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Ques9b {
    //Increase concurrency with Thread pools using newCachedThreadPool() and newFixedThreadPool().
    public static void main(String[] args) {
        ExecutorService executorService= Executors.newFixedThreadPool(3);

        for (int i = 0; i <= 10; i++) {
            executorService.submit(new Fixed(i));
        }
        executorService.shutdown();
    }
}
class Fixed implements Runnable{
    int id;

    public Fixed(int id) {
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