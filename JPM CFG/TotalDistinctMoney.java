import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TotalDistinctMoney {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int row = sc.nextInt();
            int col = sc.nextInt();

            int[][] mat = new int[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    mat[i][j] = sc.nextInt();
                }
            }

            Set<Integer> distinctSums = new HashSet<>();
            calculateSums(mat, distinctSums, 0, 0, 0);

            int totalSum = 0;
            for (int sum : distinctSums) totalSum += sum;
            System.out.println(distinctSums.size());
            System.out.println(totalSum);
        }
    }

    private static void calculateSums(int[][] mat, Set<Integer> sums, int i, int j, int currentSum) {
        currentSum += mat[i][j];

        if (i == mat.length - 1 && j == mat[0].length - 1) {
            sums.add(currentSum);
            return;
        }

        if (i < mat.length - 1) calculateSums(mat, sums, i + 1, j, currentSum);
        if (j < mat[0].length - 1) calculateSums(mat, sums, i, j + 1, currentSum);
    }
}

/*
 * Problem Statement :
 * 
 * You woke up from sleep and found yourself in the 0th row and 0th column of a
 * grid. every other square in a grid has some amount of money kept there. If
 * you are given the matrix with all the values left in the cells, you have to
 * find how many different ways are there to rich the r-1 th , c-1 th cell and
 * the sum of all possible amount of money you will have each time if you bring
 * all the money kept in places in the cell.
 * 
 * Note that, if you are in i,j th cell, either you can go i+1, j th cell or you
 * can go i,j+1 cell.
 * 
 * Again, the 0,0th grid and the n-1,m-1 th grid will have 0 value.
 * 
 * Input Format:
 * Two integers R and C meaning the number of rows and columns.
 * Next R lines C space separated integers denoting the total grid.
 * 
 * Output Format:
 * First Line denoting the distinct ways to rich.
 * Next line denotes the total money if you use all possible distinct ways
 * (Given that if you take the money from a cell, the money is readded in the
 * cell).
 * 
 * Sample Input:
 * 3 3
 * 0 2 3
 * 1 3 2
 * 1 1 0
 * 
 * Sample Output:
 * 4
 * 21
 *
 * Explanation:
 * The all possible totals are:
 * 
 * 0 -> 2 -> 3 -> 2 -> 0 Total = 7
 * 0 -> 2 -> 3 -> 2 -> 0 Total = 7
 * 0 -> 2 -> 3 -> 1 -> 0 Total = 6
 * 0 -> 1 -> 3 -> 2 -> 0 Total = 6
 * 0 -> 1 -> 3 -> 1 -> 0 Total = 5
 * 0 -> 1 -> 1 -> 1 -> 0 Total = 3
 * There are 4 distinct ways and the total is 21
 */