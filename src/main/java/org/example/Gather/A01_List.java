package org.example.Gather;

import java.util.ArrayList;
import java.util.List;

public class A01_List {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        List<Integer> list_int = new ArrayList<>();
        list_int.add(1);
        list_int.add(1);
        list_int.add(1);
        list_int.add(1);
        list_int.add(1);
        list_int.add(1);
        list_int.add(1);
        list_int.add(1);
        list_int.add(1);
        list_int.add(1);
        list_int.add(1);
        //1.list直接插入
        list.add("123");
        //2.指定位置插入
        list.add(0, "cxk");
        //3.修改指定的元素
        System.out.println(list.set(1, "xxbb"));  //xxbb
        //4.获取指定位置的元素
        System.out.println(list.get(1));     //xxbb
        //5.删除指定索引元素
        list.remove(0);
        //6.删除指定元素,如果想删除全部重复的元素,只保留一位,可以使用循环方法,或者将list直接转换为set效率更高
        list_int.remove(Integer.valueOf(1));
        System.out.println(list_int.size());
        //
    }
}
