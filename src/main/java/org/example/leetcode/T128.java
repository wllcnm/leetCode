package org.example.leetcode;

import java.util.*;

public class T128 {

    public static void main(String[] args) {
        int[] ints = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
        System.out.println(longestConsecutive(ints));
    }
    public static int longestConsecutive(int[] nums) {
        Integer[] arrs = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        List<Integer> list = Arrays.asList(arrs);
       Collections.sort(list);
        HashSet<Integer> hashSet = new LinkedHashSet<>(list);
        Integer[] array = hashSet.toArray(new Integer[0]);
        int flag=0;
        int maxLen=0;
        for(int i=0;i<array.length-1;i++){
            if(array[i]+1==array[i+1]){
                flag++;
                if(flag>=maxLen){
                    maxLen=flag;
                }
            }else{
                flag=0;
            }

        }
        return maxLen+1;
    }
}
