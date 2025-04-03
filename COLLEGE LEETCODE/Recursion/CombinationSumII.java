import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = combinationSum2(candidates, target);
        System.out.println("Combinations that sum to " + target + ": " + result);
    }

    public static List<List<Integer>> combinationSum2(int[] arr, int t) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        helper(ans, arr, t, new ArrayList<>(), 0);
        return ans;
    }

    private static void helper(List<List<Integer>> ans, int[] arr, int t, List<Integer> list, int idx) {
        if (t == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = idx; i < arr.length; i++) {
            if (i > idx && arr[i] == arr[i - 1]) continue;
            if (arr[i] > t) break;

            list.add(arr[i]);
            helper(ans, arr, t - arr[i], list, i + 1);
            list.removeLast();
        }
    }
}   