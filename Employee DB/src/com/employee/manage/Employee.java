package com.employee.manage;

public class Employee {
    private String name;
    private int id;
    private int age;
    private long salary;
    private String address;

    public String getName() {
        return name;
    }
    public int getId() {
        return id;
    }
    public int getAge() {
        return age;
    }
    public long getSalary() {
        return salary;
    }
    public String getAddress() {
        return address;
    }

    public Employee(String name, int id, int age, long salary, String address) {
        this.name = name;
        this.id = id;
        this.age = age;
        this.salary = salary;
        this.address = address;
    }
    public Employee(){}

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", age=" + age +
                ", salary=" + salary +
                ", address='" + address + '\'' +
                '}';
    }
}
