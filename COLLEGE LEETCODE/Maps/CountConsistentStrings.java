// https://leetcode.com/problems/count-the-number-of-consistent-strings/

public class CountConsistentStrings {
    public static void main(String[] args) {
        String allowed = "ab";
        String[] words = {"ad", "bd", "aaab", "baa", "badab"};
        int result = countConsistentStrings(allowed, words);
        System.out.println("Number of consistent strings: " + result);
    }

    public static int countConsistentStrings(String all, String[] words) {
        boolean[] p = new boolean[26];
        for (char c : all.toCharArray()) p[c - 'a'] = true;

        int c = 0;
        for (String s : words) if (isCst(s, p)) c++;
        return c;
    }

    private static boolean isCst(String s, boolean[] p) {
        for (int i = 0; i < s.length(); i++) {
            if (!p[s.charAt(i) - 'a']) return false;
        }
        return true;
    }
}
