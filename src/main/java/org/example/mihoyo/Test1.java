package org.example.mihoyo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取量子之海的大小
        int n = scanner.nextInt();
        int m = scanner.nextInt();

        // 读取米小游、月下和奥托主教的坐标
        int[] miPos = new int[2];
        int[] yuePos = new int[2];
        int[] ottoPos = new int[2];

        for (int i = 0; i < 3; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();

            if (i == 0) {
                miPos[0] = x;
                miPos[1] = y;
            } else if (i == 1) {
                yuePos[0] = x;
                yuePos[1] = y;
            } else {
                ottoPos[0] = x;
                ottoPos[1] = y;
            }
        }

        scanner.close();

        int[][] matrix = new int[n][m]; // 创建量子之海的矩阵，初始值为0

        int minSteps = findMinSteps(matrix, miPos, ottoPos);
        System.out.println(minSteps);
    }
    public static int findMinSteps(int[][] matrix, int[] miPos, int[] ottoPos) {
        int n = matrix.length;
        int m = matrix[0].length;

        boolean[][] visited = new boolean[n][m]; // 记录节点是否被访问过
        Queue<int[]> queue = new LinkedList<>(); // 存储待访问的节点
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // 上下左右四个方向

        queue.offer(miPos);
        visited[miPos[0] - 1][miPos[1] - 1] = true;

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] currPos = queue.poll();
                if (currPos[0] == ottoPos[0] && currPos[1] == ottoPos[1]) {
                    return steps;
                }

                for (int[] direction : directions) {
                    int nextX = currPos[0] + direction[0];
                    int nextY = currPos[1] + direction[1];

                    // 检查下一个节点是否越界或已访问过
                    if (nextX < 1 || nextX > n || nextY < 1 || nextY > m ||
                            visited[nextX - 1][nextY - 1]) {
                        continue;
                    }

                    // 检查量子之海的特殊特性
                    if (nextX == 1 && nextY == m) {
                        nextY = 1;
                    } else if (nextX == n && nextY == 1) {
                        nextY = m;
                    }

                    queue.offer(new int[] {nextX, nextY});
                    visited[nextX - 1][nextY - 1] = true;
                }
            }
            steps++;
        }

        return -1; // 如果找不到奥托主教的坐标，返回-1
    }
}
