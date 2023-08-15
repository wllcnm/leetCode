package org.example.Gather;

import java.util.Objects;

public class Student {
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private String name;

    private int age;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }


}
