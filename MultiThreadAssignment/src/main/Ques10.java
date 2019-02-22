package main;

public class Ques10 {
    //Use Synchronize method to enable synchronization between multiple threads trying to access method at same time.

    int count;

    synchronized public void incrementCount() {
        count++;
    }

    public void thread1() {
        for (int i = 1; i <= 1000; i++) {
            incrementCount();
        }
    }

    public void thread2() {
        for (int i = 1; i <= 1000; i++) {
            incrementCount();
        }
    }

    public static void main(String[] args) throws InterruptedException {

        Ques10 sync = new Ques10();
        Thread thread1 = new Thread(() -> sync.thread1());
        Thread thread2 = new Thread(() -> sync.thread2());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(sync.count);
    }

}

