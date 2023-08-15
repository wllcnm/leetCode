package org.example;

import org.example.leetcode.ListNode;

import java.nio.file.FileStore;
import java.util.*;


public class Test {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }


    public static String replace(String s) {
        return s.replace(" ", "%20");
    }

    public static String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        int flag = 0;
        char[] temp = new char[n];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = chars[i];
        }
        for (int i = n; i < s.length(); i++) {
            chars[flag++] = chars[i];
        }
        flag = 0;
        for (int i = chars.length - n; i < chars.length; i++) {
            chars[i] = temp[flag++];
        }
        return String.valueOf(chars);
    }

    public static String reverseLeftWords2(String s, int n) {
        return s.substring(0, n) + s.substring(n);
    }

    public int reverseNum(int x) {
        long s = 0;
        while (x != 0) {
            s = s * 10 + x % 10;
            x /= 10;
        }
        return s > Integer.MAX_VALUE || s < Integer.MIN_VALUE ? 0 : (int) s;
    }

    public char findTheDifference(String s, String t) {
        int sum1 = 0;
        int sum2 = 0;
        for (char c1 : s.toCharArray()) {
            sum1 = sum1 + c1;
        }
        for (char c2 : t.toCharArray()) {
            sum2 = sum2 + c2;
        }
        return (char) (sum2 - sum1);

    }

    public static boolean isNumber(String s) {

        if (s == null || s.length() <= 0) {
            return false;
        }
        char[] res = s.trim().toCharArray();
        int n = res.length;

        boolean is_dot = false; //记录是否有小数点
        boolean is_e_or_E = false; //记录是否有E/e
        boolean is_num = false; //记录前面是否出现数字

        for (int i = 0; i < n; i++) {
            if (res[i] >= '0' && res[i] <= '9') {
                is_num = true;
            } else if (res[i] == '.') {
                //成立的情况,8.8,.8.8.
                if (is_dot || is_e_or_E) {
                    return false;
                }
                is_dot = true;
            } else if (res[i] == 'E' || res[i] == 'e') {
                if (!is_num || is_e_or_E) {
                    return false;
                }
                is_e_or_E = true;
                is_num = false;
            } else if (res[i] == '-' || res[i] == '+') {
                if (i != 0 && !is_e_or_E) {
                    return false;
                }
            } else {
                return false;
            }


        }
        return is_num;
    }

    public static int strToInt(String str) {
        str = str.trim();
        char[] chars = str.toCharArray();
        if (str.length() == 0) {
            return 0;
        }
        int res = 0, bndry = Integer.MAX_VALUE / 10;
        int i = 1, sign = 1;
        if (chars[0] == '-') {
            sign = -1;
        } else if (chars[0] != '+') {
            i = 0;
        }
        for (int j = i; j < chars.length; j++) {
            if (chars[j] < '0' || chars[j] > '9') {
                break;
            }
            int temp = res * 10 + (chars[j] - '0');
            if (temp / 10 != res) {
                return sign == 1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = temp;
        }
        return res * sign;
    }

    public static int myAtoi(String s) {
        if (s.length() == 0 || s.isBlank()) return 0;
        char[] chars = s.trim().toCharArray();
        int sign = 1;
        int flag = 1;
        int res = 0;
        if (chars[0] == '-') {
            sign = -1;
        } else if (chars[0] != '+') {
            flag = 0;
        }
        for (int i = flag; i < chars.length; i++) {
            if (chars[i] < '0' || chars[i] > '9') {
                break;
            }
            int temp = res * 10 + (chars[i] - '0');
            if (temp / 10 != res) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = temp;
        }
        return res * sign;
    }

    public int[] reversePrint(ListNode head) {
        ListNode l1 = head;
        Stack<Integer> stack = new Stack<>();
        while (l1 != null) {
            stack.push(l1.val);
            l1 = l1.next;
        }
        int[] nums = new int[stack.size()];
        for (int i = 0; i < stack.size(); i++) {
            nums[i] = stack.pop();
        }
        return nums;
    }

    public static ListNode copyLinkedList(ListNode head) {
        ListNode headNew = new ListNode(head.val);
        ListNode curNew = headNew;
        ListNode curOld = head.next;
        while (curOld != null) {
            curNew.next = new ListNode(curOld.val);
            curNew = curNew.next;
            curOld = curOld.next;
        }
        return headNew;
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        while (k > 0 && fast != null) {
            fast = fast.next;
            k--;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = new ListNode(0);
        ListNode cur = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
        }
        cur.next = l1 == null ? l2 : l1;
        return newHead.next;
    }

    public static int[] exchange(int[] nums) {
        int m = 0;
        int n = nums.length - 1;
        while (n >= m) {
            while (nums[m] % 2 == 1 && m < nums.length - 1) {
                m++;
            }
            while (nums[n] % 2 == 0 && n > 0) {
                n--;
            }
            if (n <= m) {
                break;
            }
            int temp = nums[m];
            nums[m] = nums[n];
            nums[n] = temp;
        }
        return nums;
    }

    public static String reverseWords(String s) {
        int j = s.length() - 1, i = j;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            sb.append(s.substring(i + 1, j + 1)).append(" "); //添加单词
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return sb.toString().trim();
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int m = k - 1;
        int l = 0;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = m; i < nums.length; i++) {
            int[] temp = Arrays.copyOfRange(nums, l, i+1);
            Arrays.sort(temp);
            list.add(temp[temp.length - 1]);
            l++;
        }
        int[] newArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            newArr[i] = list.get(i);
        }
        return newArr;
    }
}
