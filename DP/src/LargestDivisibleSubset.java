import java.util.*;

public class LargestDivisibleSubset {

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 16, 7, 8, 4);

        List<Integer> ans = divisibleSet(arr);

        System.out.print("The longest divisible subset elements are: [");
        for (int i = 0; i < ans.size(); i++) {
            System.out.print(ans.get(i) + ", ");
        }
        System.out.println("\b\b]");
    }

    private static List<Integer> divisibleSet(List<Integer> arr) {
        int n = arr.size();

        Collections.sort(arr);

        List<Integer> dp = new ArrayList<>(Collections.nCopies(n, 1));
        List<Integer> hash = new ArrayList<>(Collections.nCopies(n, 0));

        for (int i = 0; i < n; i++) {
            hash.set(i, i);
            for (int prev = 0; prev <= i - 1; prev++) {
                if (arr.get(i) % arr.get(prev) == 0) {
                    dp.set(i, 1 + dp.get(prev));
                    hash.set(i, prev);
                }
            }
        }

        int ans = -1;
        int last = -1;

        for (int i = 0; i < n; i++) {
            if (dp.get(i) > ans) {
                ans = dp.get(i);
                last = i;
            }
        }

        List<Integer> temp = new ArrayList<>();
        temp.add(arr.get(last));

        while (hash.get(last) != last) {
            last = hash.get(last);
            temp.add(arr.get(last));
        }

        Collections.reverse(temp);
        return temp;
    }
}
