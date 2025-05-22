// https://codeforces.com/problemset/problem/34/B

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MaxProfitFromTV {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String[] st = br.readLine().split(" ");
            String[] temp = br.readLine().split(" ");

            int n = Integer.parseInt(st[0]);
            int m = Integer.parseInt(st[1]);

            int[] vals = new int[n];
            for (int i = 0; i < n; i++) vals[i] = Integer.parseInt(temp[i]);

            Arrays.sort(vals);
            int ans = 0;
            for (int i = 0; i < m; i++) {
                if (vals[i] < 0) ans -= vals[i];
                else break;
            }
            
            System.out.println(ans);
        }
    }
}