package com.qjh.udp;

/**
 * @author 231
 * @date 2020-07-04 23:48
 */
public class Employee implements java.io.Serializable{
    private String name;
    private int age;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }
}