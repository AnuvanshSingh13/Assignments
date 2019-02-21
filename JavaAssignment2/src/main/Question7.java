package main;

import java.util.Scanner;

public class Question7 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextInt();
        CovertSec(n);
    }

    private static void CovertSec(long n) {
        long day = n / (24 * 3600);

        n = n % (24 * 3600);
        long hour = n / 3600;

        n %= 3600;
        long minutes = n / 60 ;

        n %= 60;
        long seconds = n;

        System.out.println( day + " " + "days " + hour
                + " " + "hours " + minutes + " "
                + "minutes " + seconds + " "
                + "seconds ");
    }

}
