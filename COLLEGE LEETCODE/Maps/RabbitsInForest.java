// https://leetcode.com/problems/rabbits-in-forest/description/

import java.util.*;

public class RabbitsInForest {
    public static void main(String[] args) {
        RabbitsInForest solution = new RabbitsInForest();

        int[] answers1 = {1, 1, 2};
        System.out.println("Test case 1: " + solution.numRabbits(answers1)); // Expected output: 5

        int[] answers2 = {10, 10, 10};
        System.out.println("Test case 2: " + solution.numRabbits(answers2)); // Expected output: 11

        int[] answers3 = {0, 0, 1, 1, 1};
        System.out.println("Test case 3: " + solution.numRabbits(answers3)); // Expected output: 6

        int[] answers4 = {};
        System.out.println("Test case 4: " + solution.numRabbits(answers4)); // Expected output: 0

        int[] answers5 = {2, 2, 2, 2, 2};
        System.out.println("Test case 5: " + solution.numRabbits(answers5)); // Expected output: 6
    }

    // BEATS 100%
    public int numRabbits(int[] answers) {
        int fq[] = new int[1000], res = 0;
        for (int i : answers)
            if (fq[i]++ % (i + 1) == 0) res += i + 1;
        return res;
    }

    public int numRabbits_1(int[] answers) {
        int sum = 0;
        int[] fq = new int[100];
        for (int a : answers) {
            fq[a]++;
            if (fq[a] == a + 1) {
                sum += a + 1;
                fq[a] = 0;
            }
        }
        for (int a = 0; a <= 1000; a++) {
            if (fq[a] > 0) sum += a + 1;
        }
        return sum;
    }

    public int numRabbits_2(int[] answers) {
        int sum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : answers) {
            map.put(a, map.getOrDefault(a, 0) + 1);
            if (map.get(a) == a + 1) {
                sum += map.get(a);
                map.remove(a);
            }
        }
        for (int a : map.keySet()) sum += a + 1;
        return sum;
    }
}
