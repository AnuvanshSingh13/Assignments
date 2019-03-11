package com.example.databaseexample.database;

public class Employee {
    private    int    id;
    private    String name;
    private    int    quantity;
    public Employee(String name, int salary)  {
        this.name = name;
        this.quantity = salary;
    }
    public Employee(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}