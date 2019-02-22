package main;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ques16 {
    /*Create a deadlock and Resolve it using tryLock().*/
    public static void main(String[] args) throws InterruptedException {
        //ResolveDeadlock resolveDeadlock = new ResolveDeadlock();
        GenerateDeadlock generateDeadlock = new GenerateDeadlock();
        //This statement should be un-commented to generate deadlock
    }
}

class GenerateDeadlock {
    GenerateDeadlock() throws InterruptedException {
        Thread thread1 = new Thread(() -> worker1());
        Thread thread2 = new Thread(() -> worker2());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }


    Lock lock1 = new ReentrantLock(true);
    Lock lock2 = new ReentrantLock(true);

    public void worker1() {
        lock1.lock();
        System.out.println("lock 1 worker 1");
        lock2.lock();
        System.out.println("lock 2 worker 1");
        lock2.unlock();
        lock1.unlock();
    }

    public void worker2() {
        //since worker2 doesn't follow the sequence of locking and unlocking
        //it will generate deadlock
        lock2.lock();
        System.out.println("lock 1 worker 2");
        lock1.lock();
        System.out.println("lock 2 worker 2");
        lock2.unlock();
        lock1.unlock();
    }

}

class ResolveDeadlock {     //using tryLock() to resolve deadlock
    ResolveDeadlock() throws InterruptedException {
        Thread thread1 = new Thread(() -> worker1());
        Thread thread2 = new Thread(() -> worker2());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
    }

    Lock lock1 = new ReentrantLock(true);
    Lock lock2 = new ReentrantLock(true);

    public void acquireLock(Lock lock1, Lock lock2) {

        boolean acquireLock1 = lock1.tryLock();     /*tryLock() obtains the lock only if the lock is available*/
        boolean acquireLock2 = lock2.tryLock();

        if (acquireLock1 && acquireLock2) {
            return;
        }

        //If it fails to acquire both lock, it releases existing locks
        if (acquireLock1) {
            lock1.unlock();
        }

        if (acquireLock2) {
            lock2.unlock();
        }

    }

    public void worker1() {
        acquireLock(lock1, lock2);
        System.out.println("lock 1 worker 1");
        System.out.println("lock 2 worker 1");
        lock2.unlock();
        lock1.unlock();
    }

    public void worker2() {
        acquireLock(lock2, lock1);
        System.out.println("lock 1 worker 2");
        System.out.println("lock 2 worker 2");
        lock2.unlock();
        lock1.unlock();
    }
}
