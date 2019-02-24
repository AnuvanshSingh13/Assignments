package main;

import java.util.HashSet;
import java.util.Scanner;

public class Ques2 {
  //  Write a method that takes a string and returns the number of unique characters in the string.
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String");
        String st=sc.nextLine();
        HashSet <Character> hashSet=new HashSet<>();
        char[] chars = st.toCharArray();
        for (char ch: chars){
           hashSet.add(ch);
        } System.out.println("There are "+hashSet.size()+" Unique Charecter");
    }
}
