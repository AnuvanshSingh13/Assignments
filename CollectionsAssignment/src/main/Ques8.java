package main;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ques8 {
    /*
       Write a program to format date as example "21-March-2016"
   */
    public static void main(String[] args) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy");
        String date = simpleDateFormat.format(new Date());
        System.out.println("Today's date in dd-MMMM-yyyy format is: " + date);
    }
}
