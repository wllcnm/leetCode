package org.example.xhs;

import java.util.Scanner;

public class Test3 {

    /*
    * 题目描述：
小红很喜欢前往小红书分享她的日常生活。已知她生活中有n个事件，分享第i个事件需要她花费ti的时间和hi的精力来编辑文章，并能获得ai的快乐值。

小红想知道，在总花费时间不超过T且总花费精力不超过H的前提下，小红最多可以获得多少快乐值？



输入描述
第一行输入一个正整数n，代表事件的数量。

第二行输入两个正整数T和H，代表时间限制和精力限制。

接下来的n行，每行输入三个正整数ti,hi,ai，代表分享第i个事件需要花费ti的时间、hi的精力，收获ai的快乐值。

1 ≤ n ≤ 50

1 ≤ T,H ≤ 500

1≤ ti,hi≤ 30

1≤ ai ≤ 109

输出描述
一个整数，代表小红最多的快乐值。


样例输入
3
5 4
1 2 2
2 1 3
4 1 5
样例输出
7

提示
样例1说明

分享第一个和第三个事件即可。



样例2

输入

2

2 2

1 3 3

3 1 4

输出

0

样例2说明

显然，小红无法分享任何事件。*/

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int T = scanner.nextInt();
        int H = scanner.nextInt();

        int[][] dp = new int[H + 1][T + 1];

        for (int i = 0; i < n; i++) {
            int ti = scanner.nextInt();
            int hi = scanner.nextInt();
            int ai = scanner.nextInt();

            for (int j = H; j >= hi; j--) {
                for (int k = T; k >= ti; k--) {
                    dp[j][k] = Math.max(dp[j][k], dp[j - hi][k - ti] + ai);
                }
            }
        }

        int maxHappiness = 0;
        for (int i = 0; i <= H; i++) {
            for (int j = 0; j <= T; j++) {
                maxHappiness = Math.max(maxHappiness, dp[i][j]);
            }
        }

        System.out.println(maxHappiness);

        scanner.close();
    }
}
