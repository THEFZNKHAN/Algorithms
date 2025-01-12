import java.util.PriorityQueue;

public class KthSmallestLargest {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5 };
        int k = 2;
        System.out.println(k + "nd smallest: " + kthSmallestLargest(nums, k, true));
        System.out.println(k + "nd largest: " + kthSmallestLargest(nums, k, false));
    }

    private static int kthSmallestLargest(int[] nums, int k, boolean isSmallest) {
        if (k > nums.length || k < 1) return -1;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> isSmallest ? Integer.compare(b, a) : Integer.compare(a, b));
        for (int n : nums) {
            pq.offer(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
