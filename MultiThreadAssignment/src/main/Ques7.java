package main;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Ques7 {
    /*Submit List of tasks to ExecutorService and wait for the completion of all the tasks.*/
    public static void main(String[] args) throws InterruptedException {

        //Using concept of countdown latch for taking record of number of threads submitted
        //and number of threads completed.
        CountDownLatch countDownLatch = new CountDownLatch(3);
        //initializing countdownlatch to execute 3 threads
        Processor processor1 = new Processor(countDownLatch, "Worker 1");
        Processor processor2 = new Processor(countDownLatch, "Worker 2");
        Processor processor3 = new Processor(countDownLatch, "Worker 3");
        new Thread(processor1).start();
        new Thread(processor2).start();
        new Thread(processor3).start();
        countDownLatch.await(5, TimeUnit.SECONDS);
        //waiting for a max of 5 seconds for threads to complete execution
        System.out.println("Ended");

    }
}
class Processor implements Runnable {

    CountDownLatch countDownLatch;
    String name;

    public Processor(CountDownLatch countDownLatch, String name) {
        this.countDownLatch = countDownLatch;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("name :: " + name);
        countDownLatch.countDown();
    }
}