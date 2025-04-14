public class MedianOf2SortedArrays {
    public static void main(String[] args) {
        int[] a = {1, 3, 8};
        int[] b = {7, 9, 10, 11};
        double median = medianOf2(a, b);
        System.out.println("The median of the two sorted arrays is: " + median);
    }

    public static double medianOf2(int a[], int b[]) {
        int n1 = a.length, n2 = b.length;
        int n = n1 + n2;
        int left = (n1 + n2 + 1) / 2;

        int low = 0, high = n1;
        while (low <= high) {
            int mid1 = low + (high - low) / 2;
            int mid2 = left - mid1;
            
            int l1 = (mid1 > 0) ? a[mid1 - 1] : Integer.MIN_VALUE;
            int l2 = (mid2 > 0) ? b[mid2 - 1] : Integer.MIN_VALUE;
            int r1 = (mid1 < n1) ? a[mid1] : Integer.MAX_VALUE;
            int r2 = (mid2 < n2) ? b[mid2] : Integer.MAX_VALUE;
            
            if (l1 <= r2 && l2 <= r1) {
                if (n % 2 == 1) return (double)(Math.max(l1, l2));
                return (double) ((Math.max(l1, l2) + Math.min(r1, r2)) / 2.0);
            } else if (l1 > r2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }
        return (double) 0;
    }
}
