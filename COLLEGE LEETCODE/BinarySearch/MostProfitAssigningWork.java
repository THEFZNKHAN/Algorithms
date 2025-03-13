import java.util.*;

class  MostProfitAssigningWork {
    public static void main(String[] args) {
        int[] difficulty1 = {2, 4, 6, 8, 10};
        int[] profit1 = {10, 20, 30, 40, 50};
        int[] worker1 = {4, 5, 6, 7};
        System.out.println(maxProfitAssignment(difficulty1, profit1, worker1)); // 100

        int[] difficulty2 = {85, 47, 57};
        int[] profit2 = {24, 66, 99};
        int[] worker2 = {40, 25, 25};
        System.out.println(maxProfitAssignment(difficulty2, profit2, worker2)); // 0

        int[] difficulty3 = {68, 35, 52, 47, 86};
        int[] profit3 = {67, 17, 1, 81, 3};
        int[] worker3 = {92, 10, 85, 84, 82};
        System.out.println(maxProfitAssignment(difficulty3, profit3, worker3)); // 324
    }

    // MORE OPTIMIZED    
    public static int maxProfitAssignment(int[] diff, int[] profit, int[] worker) {
        int maxD = 0;
        for (int d : diff) maxD = d > maxD ? d : maxD;

        int[] maxP = new int[maxD + 1];
        for (int i = 0; i < diff.length; i++) maxP[diff[i]] = Math.max(maxP[diff[i]], profit[i]);

        for (int i = 1; i <= maxD; i++) maxP[i] = Math.max(maxP[i], maxP[i - 1]);

        int ans = 0;
        for (int a : worker) {
            if (a > maxD) ans += maxP[maxD];
            else ans += maxP[a];
        }

        return ans;
    }

    public static int maxProfitAssignment_2(int[] difficulty, int[] profit, int[] worker) {
        List<int[]> jobs = new ArrayList<>();
        jobs.add(new int[] { 0, 0 });
        for (int i = 0; i < difficulty.length; i++) {
            jobs.add(new int[] { difficulty[i], profit[i] });
        }

        Collections.sort(jobs, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 0; i < jobs.size() - 1; i++) {
            jobs.get(i + 1)[1] = Math.max(jobs.get(i)[1],  jobs.get(i + 1)[1]);
        }

        int ans = 0;
        for (int i = 0; i < worker.length; i++) {
            int l = 0, r = jobs.size() - 1, curr = 0;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (jobs.get(mid)[0] <= worker[i]) {
                    curr = Math.max(curr, jobs.get(mid)[1]);
                    l = mid + 1;
                } else r = mid - 1;
            }
            ans += curr;
        }
        return ans;
    }
}