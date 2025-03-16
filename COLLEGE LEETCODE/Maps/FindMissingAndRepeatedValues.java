// https://leetcode.com/problems/find-missing-and-repeated-values/description/

public class FindMissingAndRepeatedValues {
    public static void main(String[] args) {
        int[][] grid = {
            {1, 2, 3},
            {4, 6, 6},
            {7, 8, 9}
        };

        FindMissingAndRepeatedValues solver = new FindMissingAndRepeatedValues();
        int[] result = solver.findMissingAndRepeatedValues(grid);

        System.out.println("Repeated Value: " + result[0]);
        System.out.println("Missing Value: " + result[1]);
    }

    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int l = grid.length;
        int[] t = new int[l*l + 1];
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                t[grid[i][j]]++;
            }
        }

        int[] ans = new int[2];
        for (int i = 1; i <  t.length; i++) {
            if (t[i]  == 2) ans[0] = i;
            else if (t[i] == 0) ans[1] = i;
            if (ans[0] != 0 && ans[1] != 0) return ans;
        }
        return ans;
    }

}
