import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FirstNegativeInWindow {
    public static void main(String[] args) {
        int[] arr = {12, -1, -7, 8, -15, 30, 16, 28};
        int k = 3;
        List<Integer> result = firstNegInt(arr, k);
        System.out.println("First negative integers in each window of size " + k + ": " + result);
    }

    private static  List<Integer> firstNegInt(int[] arr, int k) {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        int r = 0;

        while (r < n) {
            if (arr[r] < 0) queue.add(r);
            if (r >= k - 1) {
                while (!queue.isEmpty() && queue.peek() <= r - k) queue.poll();
                if (!queue.isEmpty()) result.add(arr[queue.peek()]);
                else result.add(0);
            }
            r++;
        }
        return result;
    }
}
