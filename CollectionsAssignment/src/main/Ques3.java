package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ques3 {
    public static void main(String[] args) {
        //Write a method that takes a string and print the number of occurrence of each character characters in the string.
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the String to find the occurrence of the each charecter");
        String string=sc.nextLine();
        char[] str=string.toCharArray();
        HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
        for (char c:str){

            if(charCountMap.containsKey(c)){
                charCountMap.put(c,charCountMap.get(c)+1);

            }else{
                charCountMap.put(c,1);
            }
        }
        for (Map.Entry entry:charCountMap.entrySet()){
            System.out.println(entry.getKey()+" "+entry.getValue());
        }

    }
}
