package main;

public class Ques1b extends Thread{
    //Create and Run a Thread using Runnable Interface and Thread class.
    @Override
    public void run(){
        System.out.println("Thread Running");
    }

    public static void main(String[] args) {
        new Ques1b().start();
    }

}
