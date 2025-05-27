// https://codeforces.com/problemset/problem/71/A

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WayTooLongWords {
    public static void main(String[] args) throws IOException{
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            while (t-- > 0) {
                String s = br.readLine();
                int l = s.length();
                if (l <= 10) sb.append(s).append('\n');
                else sb.append(s.charAt(0)).append(l - 2).append(s.charAt(l - 1)).append('\n');
            }
            System.out.println(sb);
        }
    }
}