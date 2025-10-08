import java.util.*;

public class DuplicateElement {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 3, 2, 1};
        System.out.println(Arrays.toString(findDuplicates(arr)));

    }

    private static int[]  findDuplicates(int[] arr) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> ans = new HashSet<>();

        for (int a : arr) {
            if (set.contains(a)) ans.add(a);
            else set.add(a);
        }

        int[] res = new int[ans.size()];
        int i = 0;
        for (Integer x : ans) {
            res[i++] = x;
        }

        return res;
    }
}
