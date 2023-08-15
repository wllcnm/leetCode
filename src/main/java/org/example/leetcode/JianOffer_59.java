package org.example.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class JianOffer_59 {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1 - k, j = 0; j < n; i++, j++) {
            if (i > 0 && deque.peekFirst().equals(nums[i])) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && nums[j] > deque.peekFirst()) {
                deque.removeLast();
            }
            deque.addLast(nums[j]);
            if (i > 0) {
                res[i] = deque.peekFirst();
            }
        }
        return res;
    }

    public static int[] maxSlidingWindow1(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        int i, j;
        Deque<Integer> deque = new ArrayDeque<>();
        for (i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for (int m = k; m < n; m++) {
            if (nums[m - k] == deque.peekFirst()) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i])
                deque.removeLast();
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}
