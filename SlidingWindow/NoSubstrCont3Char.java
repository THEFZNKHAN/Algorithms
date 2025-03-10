// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/

public class NoSubstrCont3Char {
    public static void main(String[] args) {
        String s = "abcabc";
        int result = numberOfSubstrings(s);
        System.out.println("Number of substrings containing all three characters: " + result);
    }

    public static int numberOfSubstrings(String s) {
        int ans = 0, n = s.length();
        char[] c = s.toCharArray();
        int[] f = { -1, -1, -1 };
        for (int i = 0; i < n; i++) {
            f[c[i] - 'a'] = i;
            if (f[0] != -1 && f[1] != -1 && f[2] != -1) {
                int m = min(f);
                ans += m + 1;
            }
        }
        return ans;
    }

    private static int min(int[] fq) {
        if (fq[0] < fq[1] && fq[0] < fq[2]) return fq[0]; 
        if (fq[1] < fq[0] && fq[1] < fq[2]) return fq[1]; 
        return fq[2]; 
    }
}
