// https://codeforces.com/problemset/problem/2057/B

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GorillaAndTheExam {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int t = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            while (t-- > 0) {
                String[] s = br.readLine().split(" ");
                int n = Integer.parseInt(s[0]);
                int k = Integer.parseInt(s[1]);
                String[] arr = br.readLine().split(" ");

                Map<String, Integer> map = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
                }

                int size = map.size();
                for (Map.Entry<String, Integer> entry : map.entrySet().stream()
                        .sorted((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                        .collect(Collectors.toList())) {
                    if (entry.getValue() <= k) {
                        size--;
                        k -= entry.getValue();
                    } else break;
                }
                size = Math.max(size, 1);
                sb.append(size).append("\n");
            }
            System.out.println(sb);
        }
    }
}