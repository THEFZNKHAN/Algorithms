// https://leetcode.com/problems/longest-substring-without-repeating-characters/description/

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] fq = new int[256];
        char[] c = s.toCharArray();

        int i = 0, max = 0;
        for (int j = 0; j < n; j++) {
            i = Math.max(i, fq[c[j]]);
            max = Math.max(max, j - i + 1);
            fq[c[j]] = j + 1;
        }
        return max;
    }
}
