package main;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ques15 {
    /*Use Reentract lock for coordinating 2 threads with signal(), signalAll() and wait().*/
    Lock lock = new ReentrantLock(true);
    Condition condition = lock.newCondition();

    public void worker1() {
        try {
            lock.lock();
            System.out.println("worker 1 Started");
            condition.await();      //waiting for other threads to complete their execution
            System.out.println("worker 1 Finished");
            condition.signalAll();
            //upon completion, worker1 signals all waiting threads(worker2 and worker3) to execute
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public void worker2() {
        try {
            lock.lock();
            System.out.println("worker 2 Started");
            condition.await();      //waiting for other threads to complete their execution
            System.out.println("worker 2 Finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void worker3() {
        try {
            lock.lock();
            System.out.println("worker 3 Started");
            condition.await();      //waiting for other threads to complete their execution
            System.out.println("worker 3 Finished");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void worker4() {
        try {
            lock.lock();
            System.out.println("worker 4 Started");
            condition.signal();
            //signalling latest waiting thread (worker1 in the given scenario) to continue execution
            System.out.println("worker 4 Finished");
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Ques15 demo = new Ques15();
        Thread thread1 = new Thread(() -> demo.worker1());
        Thread thread2 = new Thread(() -> demo.worker2());
        Thread thread3 = new Thread(() -> demo.worker3());
        Thread thread4 = new Thread(() -> demo.worker4());
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
    }
}
