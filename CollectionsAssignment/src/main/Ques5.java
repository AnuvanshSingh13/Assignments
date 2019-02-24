package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ques5 {
    public static void main(String[] args) {
        //Write a program to sort the Student objects based on Score ,
        // if the score are same then sort on First Name . Class Student{ String Name; Double Score; Double Age
        ArrayList<Student> students=new ArrayList<Student>();
        students.add(new Student("Anuvansh",99d,21d));
        students.add(new Student("Aditya",98d,22d));
        students.add(new Student("Aman",99d,20d));
        students.add(new Student("Ashu",97d,22d));
        students.add(new Student("Aparna",95d,20d));

        System.out.println("unsorted list:");
        for (Student student:students){
            System.out.println(student.getName()+"\t"+student.getScore()+"\t"+student.getAge());
        }
        System.out.println("Sorted List");
        Collections.sort(students, new SortByScore());
        for (Student stu : students) {
            System.out.println(stu.getName() + "\t" +stu.getScore() + "\t"+ stu.getAge()  );
        }
    }


}
    class Student {
        private Double score;
        private String name;
        private Double age;

        public Student(String name, Double score, Double age) {
            this.name=name;
            this.score=score;
            this.age=age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Double getScore() {
            return score;
        }

        public void setScore(Double score) {
            this.score = score;
        }

        public Double getAge() {
            return age;
        }

        public void setAge(Double age) {
            this.age = age;
        }
    }
    class SortByScore implements Comparator<Student> {

        @Override
        public int compare(Student o1, Student o2) {
            int compResult = (int) (o1.getScore() - o2.getScore());
            return (compResult == 0 ? new SortByFirstName().compare(o1, o2) : compResult);
        }
    }
        class SortByFirstName {
            public int compare(Student o1, Student o2) {
                return (o1.getName().compareTo(o2.getName()));
            }
        }


