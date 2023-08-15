package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {


    public void MapCircle1() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 1);
        hashMap.put(2, 1);
        hashMap.put(3, 1);
        hashMap.put(4, 1);
        hashMap.put(5, 1);
        hashMap.put(6, 1);
        hashMap.put(7, 1);
        hashMap.put(8, 1);
        hashMap.put(9, 1);
        for (Map.Entry<Integer, Integer> integerEntry : hashMap.entrySet()) {
            System.out.println(integerEntry.getKey());
            System.out.println(integerEntry.getValue());
        }


    }

    public void MapCircle2() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 1);
        hashMap.put(2, 1);
        hashMap.put(3, 1);
        hashMap.put(4, 1);
        hashMap.put(5, 1);
        hashMap.put(6, 1);
        hashMap.put(7, 1);
        hashMap.put(8, 1);
        hashMap.put(9, 1);
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
        }


    }

    public void MapCircle3() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 1);
        hashMap.put(2, 1);
        hashMap.put(3, 1);
        hashMap.put(4, 1);
        hashMap.put(5, 1);
        hashMap.put(6, 1);
        hashMap.put(7, 1);
        hashMap.put(8, 1);
        hashMap.put(9, 1);
        hashMap.forEach((key, value) -> {
            System.out.println(key + value);
        });


    }


    public static void main(String[] args) {
        Main main = new Main();
        main.MapCircle3();
        ArrayList<Integer> objects = new ArrayList<>();
        objects.add(1);
        objects.add(1);
        objects.add(2);
        objects.add(3);
        HashSet<Integer> hashSet = new HashSet<>(objects);
        System.out.println(hashSet);
        Integer[] arr={1,2,3,4};
        List<Integer> list = Arrays.stream(arr).collect(Collectors.toList());
        List<Integer> arr1 = List.of(arr);


    }
}