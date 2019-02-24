package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Ques4 {
    public static void main(String[] args) {
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new Employee(21d, 5000d, "Ashu"));
        employees.add(new Employee(24d, 8000d, "Adiya"));
        employees.add(new Employee(22d, 5500d, "Aparna"));
        employees.add(new Employee(20d, 7000d, "Anuvansh"));
        employees.add(new Employee(23d, 6000d, "Aman"));

        System.out.println("Unsorted List: ");
        for (Employee employee : employees) {
            System.out.println(employee.getName() + "\t" + employee.getAge() + "\t" + employee.getSalary());
        }

        System.out.println("Sorted by Employee Salary");
        Collections.sort(employees, new SortBySalary());
        for (Employee employee : employees) {
            System.out.println(employee.getName() + "\t" + employee.getAge() + "\t" + employee.getSalary());
        }
    }
}

class Employee {
    Double age;
    Double salary;
    String name;

    public Employee(Double age, Double salary, String name) {
        this.age = age;
        this.salary = salary;
        this.name = name;
    }

    public Double getAge() {
        return age;
    }

    public void setAge(Double age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class SortBySalary implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return (int) (o1.salary - o2.salary);
    }
}