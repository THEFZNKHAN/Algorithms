import java.util.Arrays;

public class SortZeroOneTwo {
    public static void main(String[] args) {
        int[] arr = { 0, 1, 2, 0, 1, 2, 0, 1, 2 };
        dutchNationalFlag(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void dutchNationalFlag(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            switch (arr[mid]) {
                case 0 -> {
                    swap(arr, low, mid);
                    low++;
                    mid++;
                }
                case 1 -> mid++;
                default -> {
                    swap(arr, mid, high);
                    high--;
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
