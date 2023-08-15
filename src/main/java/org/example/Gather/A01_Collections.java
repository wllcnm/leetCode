package org.example.Gather;

import java.util.ArrayList;
import java.util.Collection;

public class A01_Collections {
    public static void main(String[] args) {
        Collection<String> collection = new ArrayList<>();

        //1.添加
        collection.add("cxk");
        collection.add("123");
        System.out.println(collection);

        //2.清空
        //collection.clear();

        //3.删除
        collection.remove("cxk");

        //4.判断元素是否存在
        boolean isFlag = collection.contains("cxk");
        System.out.println(isFlag);


    }
}
