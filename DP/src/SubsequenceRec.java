import java.util.ArrayList;
import java.util.List;

public class SubsequenceRec {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3 };
        List<Integer> list = new ArrayList<>();
        subsequence(0, arr.length, arr, list);
    }

    private static void subsequence(int i, int n, int[] arr, List<Integer> list) {
        if (i >= n) {
            System.out.print(list + " ");
            return;
        }
        list.add(arr[i]);
        subsequence(i + 1, n, arr, list);
        list.remove(Integer.valueOf(arr[i]));
        subsequence(i + 1, n, arr, list);
    }
}
