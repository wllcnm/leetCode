package org.example.Gather;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class A03_Collections {

    public static void main(String[] args) {
        Collection<String> coll = new ArrayList<>();

        coll.add("cxk");
        coll.add("wy");
        coll.add("wjk");
        coll.add("yyqx");

        Iterator<String> it = coll.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
