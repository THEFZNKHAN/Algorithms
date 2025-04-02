import java.util.ArrayList;
import java.util.List;

class  SplitArrayInThree {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 0, 3};
        List<Integer> result = findSplit(arr);
        System.out.println(result);
    }

    public static List<Integer> findSplit(int[] arr) {
        int sum = 0;
        for (int n : arr) sum += n;

        List<Integer> list = new ArrayList<>();
        if (sum % 3 != 0) {
            list.add(-1);
            list.add(-1);
            return list;
        }

        int n = arr.length;
        int t = sum / 3;
        int curr = 0, first = -1, second = -1;
        for (int i = 0; i < n - 1; i++) {
            curr += arr[i];
            if (curr == t && first == -1) first = i;
            if (curr == 2 * t && first != -1) {
                second = i;
                break;
            }
        }
        if (first == -1 || second == -1) {
            list.add(-1);
            list.add(-1);
            return list;
        }
        list.add(first);
        list.add(second);
        return list;
    }
}