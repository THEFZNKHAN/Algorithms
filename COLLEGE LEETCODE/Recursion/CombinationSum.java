import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        CombinationSum cs = new CombinationSum();
        List<List<Integer>> result = cs.combinationSum(candidates, target);

        System.out.println("Combinations that sum to " + target + ":");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
    }

    private List<List<Integer>> combinationSum(int[] candidates, int t) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(0, candidates, t, ans, new ArrayList<>());
        return ans;
    }

    private void helper(int idx, int[] arr, int t, List<List<Integer>> ans, List<Integer> list) {
        if (t == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (t < 0 || idx == arr.length) return;

        if (arr[idx] <= t) {
            list.add(arr[idx]);
            helper(idx, arr, t - arr[idx], ans, list);
            list.remove(list.size() - 1);
        }
        helper(idx + 1, arr, t, ans, list);
    }
}
