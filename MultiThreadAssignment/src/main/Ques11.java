package main;

public class Ques11 { //Use Synchronize block to enable synchronization between multiple threads trying to access method at same time.

    int count;

    public void incrementCount() {
        synchronized (this){
            count++;
        }
    }

    public void thread() {
        for (int i=1;i<=1000;i++){
            incrementCount();
        }
    }

    public void thread1() {
        for (int i=1;i<=1000;i++){
            incrementCount();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Ques11 synchronizeBlock = new Ques11();
        Thread thread1 = new Thread(() -> synchronizeBlock.thread());
        Thread thread2 = new Thread(() -> synchronizeBlock.thread1());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(synchronizeBlock.count);
    }

}
