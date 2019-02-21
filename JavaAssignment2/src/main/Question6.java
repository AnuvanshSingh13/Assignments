package main;

import java.util.Scanner;

public class Question6 { //WAP showing try, multi-catch and finally blocks.
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String Name=sc.nextLine();
        try{
        int n=Integer.parseInt(Name);
        if(100%n==0){
            System.out.println(Name + "is a factor of 100");
        }
        }catch(ArithmeticException e){
            System.out.println("Airthemaic Exception occured" +e);
        }catch (NumberFormatException ex){
            System.out.println("Number Format Exception" +ex);
        }catch (Exception e){
            System.out.println("Unknown Error"+e);
        }
            finally {
            System.out.println("This is finally block");
        }
    }
}
