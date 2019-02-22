package main;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class Ques12 { //Use Atomic Classes instead of Synchronize method and blocks.

    AtomicInteger count= new AtomicInteger();



    public void t1() {
        IntStream.range(1, 1001).forEach(e -> count.incrementAndGet());
    }

    public void t2() {
        IntStream.range(1, 1001).forEach(e -> count.incrementAndGet());
    }

    public static void main(String[] args) throws InterruptedException {

        Ques12 synchronizeDemo = new Ques12();
        Thread thread1 = new Thread(synchronizeDemo::t1);
        Thread thread2 = new Thread(synchronizeDemo::t2);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(synchronizeDemo.count);
    }
}
