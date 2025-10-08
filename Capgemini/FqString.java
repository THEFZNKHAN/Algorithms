public class FqString {
    public static void main(String[] args) {
        String s = "dfdkajshfjdkhsfsldf";
        System.out.println(twoTimesInTheString(s));
    }

    private static int twoTimesInTheString(String s) {
        int[] fq = new int[26];
        for (char c : s.toCharArray()) fq[c - 'a']++;

        int cnt = 0;
        for (int n : fq) {
            if (n == 2) cnt++;
        }
        return cnt;
    }
}
