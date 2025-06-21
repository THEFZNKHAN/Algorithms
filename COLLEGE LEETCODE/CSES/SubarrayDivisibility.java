import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class SubarrayDivisibility {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer in = new StringTokenizer(br.readLine());
        int t = Integer.parseInt(in.nextToken());

        in = new StringTokenizer(br.readLine());

        int[] fq = new int[t];
        fq[0] = 1;
        long cnt = 0, pre = 0;
        for (int i = 0; i < t; i++) {
            pre += Long.parseLong(in.nextToken());
            int rem = (int) (pre % t);
            if (rem < 0) rem += t;
            cnt += fq[rem];
            fq[rem]++;
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(Long.toString(cnt));
        bw.flush();
    }
}
