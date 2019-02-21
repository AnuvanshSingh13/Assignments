package main;

import java.util.Scanner;

public class Question8b {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter A word");
        String word=sc.next();
        do {
            if(word.charAt(0)==word.charAt(word.length()-1)){
                System.out.println("First and last charecter are equals for the word:"+ word);

            }else {
                System.out.println("First and last charecter are NOT equals for the word:"+word);
            }
            word=sc.next();
        } while(!word.equals("done"));
    }
}
