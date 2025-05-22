// https://codeforces.com/problemset/problem/231/A

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WhetherTeamSolvedProblem {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());

            int ans = 0, ctr;
            String[] temp;
            for (int i = 0; i < n; i++) {
                temp = br.readLine().split(" ");
                ctr = 0;
                if ("1".equals(temp[0])) ctr++;
                if ("1".equals(temp[1])) ctr++;
                if ("1".equals(temp[2])) ctr++;
                if (ctr > 1) ans++;
            }

            System.out.println(ans);
        }
    }
}