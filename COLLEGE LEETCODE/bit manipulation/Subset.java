import java.util.ArrayList;
import java.util.List;

public class Subset {
    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3 };
        System.out.println(subsets(arr));
    }

    private static List<List<Integer>> subsets(int[] arr) {
        int n = arr.length;
        int size = 1 << n;
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    list.add(arr[j]);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
