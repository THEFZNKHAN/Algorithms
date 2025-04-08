import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class SumTwoValues {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int t = Integer.parseInt(firstLine[1]);

        HashMap<Integer, Integer> map = new HashMap<>();
        String[] nums = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            int val = Integer.parseInt(nums[i]);
            int complement = t - val;
            if (map.containsKey(complement)) {
                System.out.println((map.get(complement) + 1) + " " + (i + 1));
                return;
            }
            map.put(val, i);
        }
        System.out.println("IMPOSSIBLE");
    }
}