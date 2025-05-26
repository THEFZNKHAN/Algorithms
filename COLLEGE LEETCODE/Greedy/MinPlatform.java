// https://www.geeksforgeeks.org/problems/minimum-platforms-1587115620/1

import java.util.Arrays;

class MinPlatform {
    public static void main(String[] args) {
        int[] arr = new int[]{900, 940, 950, 1100, 1500, 1800};
        int[] dep = new int[]{910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr, dep));
    }

    public static int findPlatform(int arr[], int dep[]) {
        int n = arr.length;

        Arrays.sort(arr);
        Arrays.sort(dep);

        int temp = 1, max = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                temp++;
                i++;
            } else {
                temp--;
                j++;
            }
            max = Math.max(max, temp);
        }

        return max;
    }
}
