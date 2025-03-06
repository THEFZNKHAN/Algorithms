import java.util.Scanner;

public class BinarySearch {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the array length: ");
            int n = sc.nextInt();
            int[] arr = new int[n];

            System.out.print("Enter the elements: ");
            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            System.out.print("Enter the target element: ");
            int t = sc.nextInt();

            System.out.println(binarySearch(arr, t));
            System.out.println(binarySearchRec(arr, t, 0, arr.length - 1));

            System.out.println(totalNegative(new int[]{8, 6, -5, -10, -11, -15, -20, -20}));
        }
    }

    private static int binarySearch(int[] arr, int t) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == t) return mid;
            else if (arr[mid] > t) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    private static int binarySearchRec(int[] arr, int t, int left, int right) {
        if (left > right) return -1;
        int mid = left + (right - left) / 2;
        if (arr[mid] == t) return mid;
        else if (arr[mid] > t) return binarySearchRec(arr, t, mid + 1, right);
        else return binarySearchRec(arr, t, left, mid - 1);
    }

    private static int totalNegative(int[] arr) {
        int n = arr.length;
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] < 0) r = mid - 1;
            else l = mid + 1;
        }
        return n - l;
    }
}
