package main;

public class Ques2 {
    //Write a program to find the number of occurrences of the duplicate words in a string and print them ?
    public static void main(String[] args) {
        String str= " hello welcome to java java world hello";
        String[] word= str.split(" ");
        int count=1;
        for (int i = 1; i<word.length;i++){
            for(int j=i+1;j<word.length;j++){
                if(word[i].equals(word[j])){
                    count =count+1;
                    word[j]="0";
                }
            }
            if (word[i]!="0"){
                System.out.println(word[i]+"-"+count);
                count=1;
            }
        }

    }
}
