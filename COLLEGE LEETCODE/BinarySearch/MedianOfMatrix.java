// https://www.geeksforgeeks.org/problems/median-in-a-row-wise-sorted-matrix1527/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=median-in-a-row-wise-sorted-matrix

class MedianOfMatrix {
    public static void main(String[] args) {
        int[][] mat = {
            {1, 3, 8},
            {2, 6, 9},
            {3, 6, 10}
        };
    
        int result = median(mat);
        System.out.println(result);
    }

    private static int median(int mat[][]) {
        int n = mat.length, m = mat[0].length;
        int e = 0, s = 2001;
        for (int i = 0; i < n; i++) {
            s = Math.min(s, mat[i][0]);
            e = Math.max(e, mat[i][m - 1]);
        }
        
        int med = (n * m) / 2;
        while (s <= e) {
            int mid = (s + e) / 2;
            int min = count(mat, n, m, mid);
            if (min <= med) s = mid + 1;
            else e = mid - 1;
        }
        
        return s;
    }
    
    private static int count(int[][] mat, int n, int m, int k) {
        int ctr = 0;
        for (int i = 0; i < n; i++) {
            int s = 0, e = m - 1;
            while (s <= e) {
                int mid = (s + e) / 2;
                if (mat[i][mid] <= k) s = mid + 1;
                else e = mid - 1;
            }
            ctr += s;
        }
        return ctr;
    }
}