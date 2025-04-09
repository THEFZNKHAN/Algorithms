import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BitStrings {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long res = 1;
        for (int i = 0; i < n; i++) res = (res * 2) % 1000000007;
        System.out.println(res);
    }
}
