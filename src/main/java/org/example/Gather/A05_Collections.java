package org.example.Gather;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;

public class A05_Collections {
    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();

        coll.add("cxk");
        coll.add("wy");
        coll.add("wjk");
        coll.add("yyqx");
        coll.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        });
        coll.forEach(System.out::println);
    }
}
