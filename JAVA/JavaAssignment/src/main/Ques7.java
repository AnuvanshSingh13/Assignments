package main;

public class Ques7 {
    static  String First_name;
    static String Last_name;
    static int age=22;
    static{
        First_name= "Anuvansh";


    }
    public static String Lastname(){
        Last_name="Singh";
        return Last_name;
    }

    public static void main(String[] args) {
        Ques7.Lastname();
        System.out.println("First Name: "+First_name+" Last Name: "+Last_name+" AGE: "+age);
    }
}
