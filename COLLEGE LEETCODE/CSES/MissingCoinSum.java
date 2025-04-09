import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MissingCoinSum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(input[i]);

        Arrays.sort(arr);

        int pre = 0;
        for (int x : arr) {
            if (x <= pre + 1) pre += x;
            else {
                System.out.println(pre + 1);
                return;
            }
        }

        System.out.println(pre + 1);
    }
}
