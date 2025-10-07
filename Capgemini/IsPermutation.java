public class IsPermutation {
    public static void main(String[] args) {
        String s1 = "jgddf";
        String s2 = "dfjgd";
        System.out.println(isPermutation(s1, s2));
    }

    private static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        int[] fq = new int[26];
        for (char c : s1.toCharArray()) fq[c - 'a']++;

        for (char c : s2.toCharArray()) {
            fq[c - 'a']--;
            if (fq[c - 'a'] < 0) return false;
        }
        return true;
    }
}
