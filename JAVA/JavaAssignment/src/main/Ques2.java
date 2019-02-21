package main;

public class Ques2 {
    //Write a program to find the number of occurrences of the duplicate words in a string and print them ?
    public static void main(String[] args) {
        String str= " hello welcome to java java world hello";
        List<String> list = Arrays.asList(str.split(" "));
        Set<String> uniqueWords = new HashSet<String>(list);
        for (String word : uniqueWords) {
            System.out.println(word + ": " + Collections.frequency(list, word));
        }
    }
}
