package main;

import java.util.ArrayList;
import java.util.Iterator;

public class Ques1 {
    public static void main(String[] args) {
        //Write Java code to define List . Insert 5 floating point numbers in List, and using an iterator, find the sum of the numbers in List.
        ArrayList<Float> floats=new ArrayList<>();
        Float sum = 0.0f;
        floats.add(1.5f);
        floats.add(7.4f);
        floats.add(6.4f);
        floats.add(4.4f);
        floats.add(5.4f);
        Iterator iterator=floats.iterator();
        System.out.println("The Sum of Float Nos =");
        while(iterator.hasNext()){
             sum = sum+(Float) iterator.next();

        }
        System.out.println(sum);


    }
}
