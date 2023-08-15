package org.example.Gather;

import java.util.ArrayList;
import java.util.Collection;

public class A04_Collections {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();

        coll.add("cxk");
        coll.add("wy");
        coll.add("wjk");
        coll.add("yyqx");
        for (String s : coll) {
            System.out.println(s);
        }
    }
}
