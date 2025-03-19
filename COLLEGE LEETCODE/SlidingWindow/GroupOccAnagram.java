// https://www.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1

// Company Tags: [Flipkart, Amazon, Microsoft, Intuit]

class GroupOccAnagram {
    public static void main(String[] args) {
        String txt = "forxxorfxdofr";
        String pat = "for";
        int result = search(pat, txt);
        System.out.println("Number of anagram occurrences: " + result);
    }

    private static int search(String pat, String txt) {
        int n = txt.length(), m = pat.length();

        int ctr = 0, ans = 0;
        char[] t = txt.toCharArray();

        int[] fq = new int[26];
        for (char c : pat.toCharArray()) fq[c - 'a']++;

        for (int i = 0; i < n; i++) {
            if (fq[t[i] - 'a'] > 0) ctr++;
            fq[t[i] - 'a']--;

            if (i >= m) {
                fq[t[i - m] - 'a']++;
                if (fq[t[i - m] - 'a'] > 0) ctr--;
            }

            if (i >= m - 1 && ctr == m) ans++;
        }
        return ans;
    }
}