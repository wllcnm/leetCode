package org.example;

public class BaiDu2021 {

    public static void main(String[] args) {
        String str="abcdef";

        String str1 = str.substring(0, 3);
        String str2 = str.substring(3);
        StringBuilder reverve1=new StringBuilder(str1).reverse();
        StringBuilder reverve2=new StringBuilder(str2).reverse();
        System.out.println(reverve1.append(reverve2).toString());

    }
}
