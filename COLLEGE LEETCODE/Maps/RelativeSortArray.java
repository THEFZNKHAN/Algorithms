// https://leetcode.com/problems/relative-sort-array/description/

public class RelativeSortArray {
    public static void main(String[] args) {
        int[] arr1 = { 2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19 };
        int[] arr2 = { 2, 1, 4, 3, 9, 6 };
        int[] result = relativeSortArray(arr1, arr2);
        System.out.println(java.util.Arrays.toString(result));

        int[] arr3 = { 28, 6, 22, 8, 44, 17 };
        int[] arr4 = { 22, 28, 8, 6 };
        int[] result2 = relativeSortArray(arr3, arr4);
        System.out.println(java.util.Arrays.toString(result2));
    }

    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        // int[] fq = new int[1001];
        int max = 0;
        for (int n : arr1) max = Math.max(n, max);

        int[] fq = new int[max + 1];
        for (int n : arr1) fq[n]++;

        int idx = 0;
        for (int i = 0; i < arr2.length; i++) {
            while (fq[arr2[i]] != 0) {
                arr1[idx++] = arr2[i];
                fq[arr2[i]]--;
            }
        }

        for (int i = 0; i < max + 1; i++) {
            while (fq[i] != 0) {
                arr1[idx++] = i;
                fq[i]--;
            }
        }

        return arr1;
    }
}
