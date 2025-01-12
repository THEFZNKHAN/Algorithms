class MinMax {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int[] result = minMax(nums);
        System.out.println("Min: " + result[0]);
        System.out.println("Max: " + result[1]);
    }
    
    private static int[] minMax(int[] nums) {
        int min = nums[0];
        int max = nums[0];
        for (int n : nums) {
            min = Math.min(min, n);
            min = Math.max(min, n);
        }
        return new int[] {min, max};
    }
}