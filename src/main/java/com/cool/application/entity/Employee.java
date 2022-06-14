package com.cool.application.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Employee {

    private String name;
    private int salary;
    private int age;

    public Employee(String name, int salary, int age) {
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", age=" + age +
                '}';
    }

    public static void main(String[] args) {
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("a", 200, 20));
        list.add(new Employee("b", 200, 90));
        list.add(new Employee("ert", 200, 8));
        list.add(new Employee("gft", 200, 878));

        Map<Integer, List<Employee>> map = list.stream()
                .peek(a -> a.setAge(a.getAge() + 1))
                .filter(a -> a.getAge() > 18)
                .sorted(Comparator.comparing(Employee::getName))
                .collect(Collectors.groupingBy(Employee::getSalary));

        for (Map.Entry<Integer, List<Employee>>  m: map.entrySet()) {
            List<Employee> l = m.getValue();
            for(Employee e : l) {
                System.out.println(e);
            }
        }




    }


}
