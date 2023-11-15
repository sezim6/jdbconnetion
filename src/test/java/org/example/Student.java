package org.example;

public class Student {
    private Long id;
    private String info;
    private int age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student( String info, int age) {
        this.id = id;
        this.info = info;
        this.age = age;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student " +
                "id " + id +
                "info " + info + '\'' +
                "age " + age ;
    }
}
