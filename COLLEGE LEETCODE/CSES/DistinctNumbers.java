import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class DistinctNumbers {
    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(br.readLine());
            Set<Integer> set = new HashSet<>();
            String[] input = br.readLine().split(" ");
            for (int i = 0; i < n; i++) set.add(Integer.valueOf(input[i]));
            System.out.println(set.size());
        }
    }
}
