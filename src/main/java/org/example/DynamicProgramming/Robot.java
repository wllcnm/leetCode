package org.example.DynamicProgramming;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class Robot {


    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        int result = way2(7, 2, 4, 4);
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("总共花费了" + (end - start) + "ms 时间");
        System.out.println(result);

    }

    public static int way1(int N, int start, int target, int k) {
        return process1(start, target, k, N);
    }


    public static int process1(int cur, int target, int rest, int N) {
        if (rest == 0) {
            return cur == target ? 1 : 0;
        }
        if (cur == 1) {
            process1(cur + 1, target, rest - 1, N);
        }
        if (cur == N) {
            process1(cur - 1, target, rest - 1, N);
        }
        return process1(cur - 1, target, rest - 1, N) + process1(cur + 1, target, rest - 1, N);
    }

    public static int way2(int N, int start, int target, int k) {
        int[][] dp = new int[N + 1][k + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        return process2(start, target, k, N, dp);
    }


    public static int process2(int cur, int target, int rest, int N, int[][] dp) {
        if (dp[cur][rest] != -1) {
            return dp[cur][rest];
        }
        int ans = 0;
        if (rest == 0) {
            return cur == target ? 1 : 0;
        } else if (cur == 1) {
            ans = process2(cur + 1, target, rest - 1, N, dp);
        } else if (cur == N) {
            ans = process2(cur - 1, target, rest - 1, N, dp);
        } else {
            ans = process2(cur - 1, target, rest - 1, N, dp) + process2(cur + 1, target, rest - 1, N, dp);
        }
        dp[cur][rest] = ans;
        return ans;
    }
}
