package main;

public class Ques1a implements Runnable{
//Create and Run a Thread using Runnable Interface and Thread class.
    @Override
    public void run() {
    System.out.println("Runnable");
    }

    public static void main(String[] args) {
        new Thread(new Ques1a()).start();
    }
}
