public class GasStation {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        int startIndex = canCompleteCircuit(gas, cost);
        System.out.println("Start index: " + startIndex);
    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int gSum = 0, cSum = 0;
        for (int n : gas) gSum += n;
        for (int n : cost) cSum += n;

        if (cSum > gSum) return -1;

        int res = 0, idx = 0;
        for (int i = 0; i < gas.length; i++) {
            res += (gas[i] - cost[i]);
            if (res < 0) {
                idx = i + 1;
                res = 0;
            }
        }
        return idx;
    }
}
