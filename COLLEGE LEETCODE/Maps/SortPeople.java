// https://leetcode.com/problems/sort-the-people/description/

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SortPeople {
    public static void main(String[] args) {
        String[] names1 = {"Alice", "Bob", "Charlie"};
        int[] heights1 = {155, 180, 165};
        System.out.println("Sorted People: " + Arrays.toString(sortPeople(names1, heights1)));

        String[] names2 = {"John", "Doe", "Jane"};
        int[] heights2 = {170, 160, 175};
        System.out.println("Sorted People: " + Arrays.toString(sortPeople(names2, heights2)));

        String[] names3 = {"Anna", "Tom", "Jerry"};
        int[] heights3 = {150, 190, 180};
        System.out.println("Sorted People: " + Arrays.toString(sortPeople(names3, heights3)));
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Map<Integer, String> hm = new HashMap<>();

        for (int i = 0; i < n; i++) hm.put(heights[i], names[i]);
        Arrays.sort(heights);

        for (int i = 0; i < n; i++) names[i] = hm.get(heights[n - 1 - i]);
        return names;
    }
}
