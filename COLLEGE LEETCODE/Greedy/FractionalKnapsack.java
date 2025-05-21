import java.util.Arrays;

class FractionalKnapsack {
    public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;
        FractionalKnapsack fk = new FractionalKnapsack();
        double maxValue = fk.fractionalKnapsack(values, weights, W);
        System.out.println("Maximum value in knapsack = " + maxValue);
    }

    class Item implements Comparable<Item> {
        int val;
        int wt;
        
        public Item(int val, int wt) {
            this.val = val;
            this.wt = wt;
        }
        
        @Override
        public int compareTo(Item that) {
            double thisRatio = (double) this.val / (double) this.wt;
            double thatRatio = (double) that.val / (double) that.wt;
            return Double.compare(thatRatio, thisRatio);
        }
    }

    double fractionalKnapsack(int[] values, int[] weights, int W) {
        int n = values.length;
        Item[] items = new Item[n];
        for (int i = 0; i < n; i++) {
            items[i] = new Item(values[i], weights[i]);
        }
        
        Arrays.sort(items);

        double ans = 0;
        for (int i = 0; i < n; i++) {
            if (W <= 0) break;
            if (items[i].wt <= W) {
                ans += items[i].val;
                W -= items[i].wt;
            } else {
                ans += ((double) items[i].val / (double) items[i].wt) * W;
                break;
            }
        }
        
        return ans;
    }
}