package main;

public class Ques14 {
    /*Coordinate multiple threads using wait() and notifyAll()*/

    public void worker1() {
        synchronized (this) {
            System.out.println("Worker 1 Started");
            try {
                wait();     //waiting for other thread to complete their execution
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Worker 1 Done");
        }
    }

    public void worker2() {
        synchronized (this) {
            System.out.println("Worker 2 Started");
            try {
                wait();     //waiting for other thread to complete their execution
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Worker 2 Done");
        }
    }

    public void worker3() {
        synchronized (this) {
            System.out.println("Worker 3 Started");
            try {
                wait();     //waiting for other thread to complete their execution
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Worker 3 Done");
        }
    }


    public void worker4() {
        synchronized (this) {
            System.out.println("Worker 4 Started");
            notifyAll();
            //upon completion of its task, worker4 notifies other waiting threads
            System.out.println("Worker 4 Done");
        }
    }

    public static void main(String[] args) {
        Ques14 demo = new Ques14();
        new Thread(() -> demo.worker1()).start();
        new Thread(() -> demo.worker2()).start();
        new Thread(() -> demo.worker3()).start();
        new Thread(() -> demo.worker4()).start();
    }
}
