import java.io.*;

public class CommonDivisors {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] freq = new int[1000001];
        String[] parts = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(parts[i]);
            freq[x]++;
        }

        for (int i = 1000000; i >= 1; i--) {
            int count = 0;
            for (int j = i; j <= 1000000; j += i) {
                count += freq[j];
                if (count >= 2) {
                    System.out.println(i);
                    return;
                }
            }
        }

        System.out.println(1);
    }
}