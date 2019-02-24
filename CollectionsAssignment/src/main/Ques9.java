package main;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Ques9 {
    /*Write a program to display times in different country format.*/
    public static void main(String[] args) {
        Date today = new Date();
        dispIST(today);     //indian standard time
        dispJST(today);     //japan standard time
        dispGMT(today);     //greenwich mean time
    }

    private static void dispGMT(Date today) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss", Locale.ENGLISH);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));        //setting time zone GMT
        System.out.println("Date in GMT is : " + dateFormat.format(today));
    }

    private static void dispJST(Date today) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss", Locale.ENGLISH);
        dateFormat.setTimeZone(TimeZone.getTimeZone("JST"));        //setting time zone JST
        System.out.println("Date in JST is : " + dateFormat.format(today));
    }

    private static void dispIST(Date today) {
        DateFormat dateFormat = new SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss", Locale.ENGLISH);
        dateFormat.setTimeZone(TimeZone.getTimeZone("IST"));        //setting time zone IST
        System.out.println("Date in IST is : " + dateFormat.format(today));
    }
}
