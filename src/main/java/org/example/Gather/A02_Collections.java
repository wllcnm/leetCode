package org.example.Gather;

import java.util.ArrayList;
import java.util.Collection;

public class A02_Collections {

    public static void main(String[] args) {
        Student s1 = new Student("xiaomei", 25);
        Student s2 = new Student("dabai", 30);

        Collection<Student> c1 = new ArrayList<>();
        c1.add(s1);
        c1.add(s2);

        Student s3 = new Student("xiaomei", 25);
        System.out.println(c1.contains(s3));

    }
}
