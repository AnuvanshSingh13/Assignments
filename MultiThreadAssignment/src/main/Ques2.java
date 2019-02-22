package main;

public class Ques2 {
    //Use sleep and join methods with thread.

    static int counter=0;
    public static void main(String[] args) throws InterruptedException {
        Thread thread=new Thread(() -> {
            try {
                Thread.sleep(1000L);
                System.out.println("Running Thread");
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        });Thread t2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000L);
                    System.out.println("Running second thread");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }


            }
        });
        thread.start();
        t2.start();
        thread.join();
        t2.join();
        System.out.println("Main Class");

    }
}
