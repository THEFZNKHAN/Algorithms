// https://leetcode.com/problems/find-common-characters/description/

import java.util.ArrayList;
import java.util.List;

class FindCommonCharacters {
    public static void main (String[] args) {
        String[][] testCases = {
            {"bella", "label", "roller"},
            {"cool", "lock", "cook"},
            {"hello", "world", "java"},
            {"abc", "bca", "cab"}
        };

        for (int i = 0; i < testCases.length; i++) {
            System.out.println("Test Case " + (i + 1) + ":");
            List<String> result = commonChars(testCases[i]);
            System.out.println(result);
            System.out.println();
        }
    }

    public static List<String> commonChars(String[] words) {
        int[] last = count(words[0]);

        for (int i = 1; i < words.length; i++) intersection(last, count(words[i]));

        List<String> arr = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (last[i] != 0) {
                char a = (char) ('a' + i);
                String s = String.valueOf(a);
                while (last[i] > 0) {
                    arr.add(s);
                    last[i]--;
                }
            }
        }
        return arr;
    }

    private static int[] intersection(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) a[i] = Math.min(a[i], b[i]);
        return a;
    }

    private static int[] count(String str) {
        int[] t = new int[26];
        for (char c : str.toCharArray()) t[c - 'a']++;
        return t;
    }
}