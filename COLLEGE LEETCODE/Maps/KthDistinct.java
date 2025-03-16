// https://leetcode.com/problems/kth-distinct-string-in-an-array/

import java.util.*;

public class KthDistinct {
    public static void main(String[] args) {
        String[] arr1 = {"a", "b", "a", "c", "b"};
        int k1 = 2;
        System.out.println("Test Case 1: " + kthDistinct(arr1, k1));

        String[] arr2 = {"x", "y", "z", "x", "y"};
        int k2 = 1;
        System.out.println("Test Case 2: " + kthDistinct(arr2, k2));

        String[] arr3 = {"apple", "banana", "apple", "orange", "banana", "grape"};
        int k3 = 1;
        System.out.println("Test Case 3: " + kthDistinct(arr3, k3));

        String[] arr4 = {"one", "two", "three", "one", "two"};
        int k4 = 2;
        System.out.println("Test Case 4: " + kthDistinct(arr4, k4));

        String[] arr5 = {"unique"};
        int k5 = 1;
        System.out.println("Test Case 5: " + kthDistinct(arr5, k5));
    }

    public static String kthDistinct(String[] arr, int k) {
        Map<String, Integer> hm = new HashMap<>();
        for (String s : arr) {
            hm.put(s, hm.getOrDefault(s, 0) + 1);
        }

        for (String s : arr) {
            if (hm.get(s) == 1 && --k == 0) return s;
        }
        return "";
    }
}
