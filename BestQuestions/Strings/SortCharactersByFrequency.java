// https://leetcode.com/problems/sort-characters-by-frequency/description/

import java.util.Arrays;

public class SortCharactersByFrequency {
    public static void main(String[] args) {
        String s = "tree";
        String result = frequencySort(s);
        System.out.println("Sorted by frequency: " + result);
    }

    public static String frequencySort(String s) {
        int[][] fq = new int[128][2];

        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i);
            fq[a][0] = a;
            fq[a][1]++;
        }

        Arrays.sort(fq, (a, b) -> Integer.compare(b[1], a[1]));
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 128; i++) {
            if (fq[i][1] == 0) break;
            for (int j = 0; j < fq[i][1]; j++) sb.append((char) fq[i][0]);
        }
        return sb.toString();
    }
}
