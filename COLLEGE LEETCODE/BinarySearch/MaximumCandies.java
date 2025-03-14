// https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/?envType=daily-question&envId=2025-03-14

class MaximumCandies {
    public static void main(String[] args) {
        int[] candies = {5, 8, 6};
        long k = 3;
        int result = maximumCandies(candies, k);
        System.out.println("Maximum candies each child can get: " + result);
    }

    public static int maximumCandies(int[] candies, long k) {
        long sum = 0;
        for (int c : candies) sum += c;

        if (sum < k) return 0;
        if (sum == k) return 1;

        int s = 1, e = (int) (sum / k);
        while (s <= e) {
            int mid =  s + (e - s) / 2;
            if (check(candies, mid, k)) s = mid + 1;
            else e = mid - 1;
        }
        return e;
    }

    public static boolean check(int[] candies, int mid, long k) {
        for (int c : candies) {
            k -= (c / mid);
            if (k <= 0) return true;
        }
        return false;
    }
}