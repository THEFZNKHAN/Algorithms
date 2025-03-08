// https://leetcode.com/problems/minimum-recolors-to-get-k-consecutive-black-blocks/description

class MinimumRecolors {
    public static void main(String[] args) {
        MinimumRecolors obj = new MinimumRecolors();
        String blocks = "WBBWWBBWBW";
        int k = 7;
        int result = obj.minimumRecolors(blocks, k);
        System.out.println("Minimum recolors needed: " + result);
    }

    public int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        char[] c = blocks.toCharArray();

        int sum = 0, max = 0;
        for (int i = 0; i < n; i++) {
            if (c[i] == 'B') sum++;
            if (i >= k && c[i - k] == 'B') sum--;
            max = Math.max(max, sum);
        }
        return k - max;
    }
}