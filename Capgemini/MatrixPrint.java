public class MatrixPrint {
    public static void main(String[] args) {
        int[][] mat = {
            {1, 2, 3, 4},
            {5, 6, 7, 8},
            {9, 10, 11, 12},
            {13, 14, 15, 16}
        };
        zigzag(mat); // Expected output: 1 2 5 9 6 3 4 7 10 13 14 11 8 12 15 16
    }

    private static void zigzag(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int total = n * m;
        int r = 0, c = 0;

        for (int i = 0; i < total; i++) {
            System.out.print(mat[r][c] + " -> ");

            if ((r + c) % 2 == 0) {
                if (c == m - 1) r++;
                else if (r == 0) c++;
                else {
                    r--;
                    c++;
                }
            } else {
                if (r == n - 1) c++;
                else if (c == 0) r++;
                else {
                    r++;
                    c--;
                }
            }
        }
    }
}
