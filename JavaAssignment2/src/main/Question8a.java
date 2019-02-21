package main;

import java.util.Scanner;

public class Question8a { //WAP to read words from the keyboard until the word done is entered. For each word except done, report whether its first character is equal   to  its last character. For the required loop, use a
                             //a)while statement
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter A word");
        String word=sc.next();
        while(!word.equals("done")){
            if(word.charAt(0)==word.charAt(word.length()-1)){
                System.out.println("First and last charecter are equals for the word:"+ word);

            }else {
                System.out.println("First and last charecter are NOT equals for the word:"+word);
            }
            word=sc.next();
        }
    }
}
