// https://leetcode.com/problems/first-unique-character-in-a-string/

public class FirstUniqChar {
    public static void main(String[] args) {
        String testString = "leetcode";
        int index = firstUniqChar(testString);
        System.out.println("The index of the first unique character is: " + index);
    }

    public static int firstUniqChar(String s) {
        char[] c = s.toCharArray();
        int[] fq = new int[256];

        for (char ch : c) fq[ch]++;

        for (int i = 0; i < c.length; i++) {
            if (fq[c[i]] == 1) return i;
        }
        return -1;
    }
}
