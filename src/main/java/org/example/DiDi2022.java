package org.example;

import java.util.Arrays;

public class DiDi2022 {


    /*
    * 合并有序数组
    *
    * */
    public static void main(String[] args) {

        int[] arr1 = new int[]{1, 2, 5, 6, 8, 10};
        int[] arr2 = new int[]{3, 4, 7, 9, 10, 11};
        int[] arr3 = new int[arr1.length + arr2.length];

        int m = 0;
        int n = 0;
        int key = 0;
        while (m < arr1.length && n < arr2.length) {
            if (arr1[m] <= arr2[n]) {
                arr3[key++] = arr1[m++];
            } else {
                arr3[key++] = arr2[n++];
            }
        }
        while (m < arr1.length) {
            arr3[key++] = arr1[m++];
        }
        while (n < arr2.length) {
            arr3[key++] = arr2[n++];
        }
        System.out.println(Arrays.toString(arr3));
    }
}
