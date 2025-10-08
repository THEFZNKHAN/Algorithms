import java.util.*;

public class ArrayIntersection {
    public static void main(String[] args) {
        int[] arr1 = { 1, 2, 2, 1, 3 };
        int[] arr2 = { 2, 3 , 1 };
        System.out.println(intersection(arr1, arr2));
    }

    private static List<Integer> intersection(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : arr1) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        List<Integer> list = new ArrayList<>();
        for (int a : arr2) {
            if (map.containsKey(a) && map.get(a) > 0) {
                list.add(a);
                map.put(a, map.getOrDefault(a, 0) - 1);
            }
        }
        return list;
    }
}
