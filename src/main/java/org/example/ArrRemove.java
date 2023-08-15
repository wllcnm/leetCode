package org.example;

import java.util.Arrays;

public class ArrRemove {


    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 2, 3, 4, 5, 5, 6};

        int slow = 0;
        int fast = 1;
        while (fast <arr.length) {
            if (arr[fast] != arr[slow]) {
                slow++;
                arr[slow] = arr[fast];
            }
            fast++;
        }
        int[] ints = new int[slow + 1];
        System.arraycopy(arr,0,ints,0,slow+1);
        System.out.println(Arrays.toString(ints));
    }
}
