package main;

public class Ques13 {
    /*
    Coordinate 2 threads using wait() and notify().
*/

    public void worker1() {
        synchronized (this) {
            System.out.println("Worker1 Started");
            try {
                wait();     //waiting for worker4 to finish its work
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Worker1 Done");
        }
    }


    public void worker4() {
        synchronized (this) {
            System.out.println("Worker 4 Started");
            notify();       //upon completion of its task, worker4 notifies worker1 to perform its task
            System.out.println("Worker 4 Done");
        }
    }

    public static void main(String[] args) {
        Ques13 demo = new Ques13();
        new Thread(() -> {
            demo.worker1();
        }).start();
        new Thread(() -> {
            demo.worker4();
        }).start();
    }
}
