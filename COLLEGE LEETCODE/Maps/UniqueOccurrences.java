// https://leetcode.com/problems/unique-number-of-occurrences/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueOccurrences {
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 1, 1, 3};
        boolean result = uniqueOccurrences(arr);
        System.out.println("Are occurrences unique? " + result);
    }

    public static boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> hm = new HashMap<>();

        for (int num : arr) hm.put(num, hm.getOrDefault(num, 0) + 1);

        Set<Integer> set = new HashSet<>();

        for (int c : hm.values()) {
            if (!set.add(c)) return false;
        }

        return true;
    }
}
