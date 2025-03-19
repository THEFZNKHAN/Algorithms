public class EqualSubstring {
    public static void main(String[] args) {
        String s = "abcd";
        String t = "bcdf";
        int maxCost = 3;
        int result = equalSubstring(s, t, maxCost);
        System.out.println("The maximum length of a substring is: " + result);
    }

    public static  int equalSubstring(String s, String t, int maxCost) {
        int l = 0, r = 0, n = s.length();
        int curr = 0, max = 0;
        while (r < n) {
            curr += Math.abs(s.charAt(r) - t.charAt(r));
            while (curr > maxCost) {
                curr -= Math.abs(s.charAt(l) - t.charAt(l));
                l++;
            } 
            if (max < r - l + 1) max = r - l + 1;
            r++;
        }
        return max;
    }
}
