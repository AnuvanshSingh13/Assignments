package main;

import java.util.Scanner;

public class Ques3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("enter the string");
        String str=sc.nextLine();
        System.out.println("enter the charecter");
        char ch=sc.next().charAt(0);
        System.out.println("Length Of String:" + str.length());
        System.out.println("lenght of string without charecter"+str.replaceAll(String.valueOf(ch),"").length());
        int count= str.length()-str.replaceAll(String.valueOf(ch),"").length();
        System.out.println("the occurance of given chareceter "+ch+" is:"+count);
    }
}
