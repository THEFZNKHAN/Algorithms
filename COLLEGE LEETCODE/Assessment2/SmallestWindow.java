public class SmallestWindow {
    public static void main(String[] args) {
        String s1 = "this is a test string";
        String s2 = "tist";
        String result = smallestWindow(s1, s2);
        if (result.isEmpty()) {
            System.out.println("No such window exists");
        } else {
            System.out.println("Smallest window is: " + result);
        }
    }

    public static String smallestWindow(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if (l2 > l1) return "";

        int[] fq = new int[26];
        int ctr = 0;
        for (char c : s2.toCharArray()) {
            if (fq[c - 'a'] == 0) ctr++;
            fq[c - 'a']++;
        }

        int l = 0, r = 0, ans = Integer.MAX_VALUE;
        int s = -1;

        while (r < l1) {
            fq[s1.charAt(r) - 'a']--;
            if (fq[s1.charAt(r) - 'a'] == 0) ctr--;
            while (ctr == 0) {
                if (r - l + 1 < ans) {
                    ans = r - l + 1;
                    s = l;
                }
                fq[s1.charAt(l) - 'a']++;
                if (fq[s1.charAt(l) - 'a'] > 0) ctr++;
                l++;
            }
            r++;
        }
        if (s == -1) return "";
        return s1.substring(s, s + ans);
    }
}
