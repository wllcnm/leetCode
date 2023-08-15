package org.example;

import java.util.HashMap;
import java.util.Map;

public class SmallestSubString {
    public static String findSmallestSubString(String str1, String str2) {
        Map<Character, Integer> targetCharMap = new HashMap<>();
        for (char c : str2.toCharArray()) {
            targetCharMap.put(c, targetCharMap.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int count = str2.length();
        int minLen = Integer.MAX_VALUE;
        String result = "";

        while (right < str1.length()) {
            char currentChar = str1.charAt(right);

            if (targetCharMap.containsKey(currentChar)) {
                int targetCharCount = targetCharMap.get(currentChar);
                targetCharMap.put(currentChar, targetCharCount - 1);

                if (targetCharCount >= 1) {
                    count--;
                }
            }
            right++;

            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    result = str1.substring(left, right);
                }

                char leftChar = str1.charAt(left);

                if (targetCharMap.containsKey(leftChar)) {
                    int leftCharCount = targetCharMap.get(leftChar);
                    targetCharMap.put(leftChar, leftCharCount + 1);

                    if (leftCharCount >= 0) {
                        count++;
                    }
                }
                left++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String str1 = "meituan2019";
        String str2 = "i2t";

        String result = findSmallestSubString(str1, str2);
        System.out.println(result);
    }
}