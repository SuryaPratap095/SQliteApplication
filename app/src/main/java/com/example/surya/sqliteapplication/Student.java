package com.example.surya.sqliteapplication;

/**
 * Created by surya on 12/11/16.
 */
public class Student {

    private int id;
    private String name;
    private String city;

    public Student() {

    }

    public Student(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Student(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
