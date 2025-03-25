import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class GeeksLikeYou {
    public static void main(String[] args) {
        int[] A = { 1, -2, 3, 4, -5, 6 };
        int n = A.length;

        ArrayList<Integer> result = findAnswer(n, A);
        System.out.println("Result: " + result);
    }

    public static ArrayList<Integer> findAnswer(int n, int[] A) {
        ArrayList<Integer> answer = new ArrayList<>();

        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + A[i];
        }

        int[] nextGreater = new int[n + 1];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = n; i >= 0; i--) {
            while (!stack.isEmpty() && prefixSum[stack.peek()] <= prefixSum[i]) {
                stack.pop();
            }
            Integer top = stack.peek();
            nextGreater[i] = (stack.isEmpty() || top == null) ? -1 : top;
            stack.push(i);
        }

        for (int i = 0; i < n; i++) {
            int k = nextGreater[i];
            if (k != -1 && k <= n) answer.add(k - i);
            else answer.add(0);
        }

        return answer;
    }

    // BRUTE FORCE
    public static ArrayList<Integer> findAnswer_(int n, int[] A) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) list.add(helper(A, i, n));
        return list;
    }

    private static int helper(int[] nums, int i, int n) {
        long sum = 0;
        for (int j = i; j < n; j++) {
            sum += nums[j];
            if (sum > 0) return j - i + 1;
        }
        return 0;
    }
}
