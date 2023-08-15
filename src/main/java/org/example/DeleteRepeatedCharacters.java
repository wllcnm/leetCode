package org.example;

public class DeleteRepeatedCharacters {
    public static String deleteRepeatedChars(String str) {
        StringBuilder sb = new StringBuilder();
        int len = str.length();
        int i = 0;

        while (i < len) {
            int flag = 0;
            char current = str.charAt(i);

            while (i + 1 < len && str.charAt(i + 1) == current) {
                i++;
                flag = 1;
            }
            if (flag == 0) {
                sb.append(current);
            }
            i++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        String originalString = "aaaabababaa";
        String result = deleteRepeatedChars(originalString);
        System.out.println(result);
    }
}