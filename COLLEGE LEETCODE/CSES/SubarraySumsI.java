import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class SubarraySumsI {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(in.nextToken());
        int t = Integer.parseInt(in.nextToken());

        StringTokenizer arr = new StringTokenizer(bf.readLine());

        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);
        long pre = 0, cnt = 0;
        for (int i = 0; i < n; i++) {
            pre += Long.parseLong(arr.nextToken());
            long need = pre - t;
            cnt += map.getOrDefault(need, 0L);
            map.put(pre, map.getOrDefault(pre, 0L) + 1);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Long.toString(cnt));
        bw.flush();
    }
}
