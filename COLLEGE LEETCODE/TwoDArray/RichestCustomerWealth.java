import java.util.*;

class RichestCustomerWealth {

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();

        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Give matrix row size: ");
            int row = sc.nextInt();
            System.out.print("Give matrix column size: ");
            int col = sc.nextInt();
            
            for (int i = 0; i < row; i++) {
                List<Integer> t = new ArrayList<>();
                System.out.print("Enter the elements of the " + i + "th row: ");
                for (int j = 0; j < col; j++) {
                    int a = sc.nextInt();
                    t.add(a);
                }
                list.add(t);
            }
    
            System.out.println(maximumWealth(list));
        }
    }

    public static int maximumWealth(List<List<Integer>> accounts) {
        int maxSum = 0;
        for (List<Integer> account : accounts) {
            int sum = 0;
            for (int j = 0; j < accounts.get(0).size(); j++) {
                sum += account.get(j);
            }
            if (sum > maxSum) maxSum = sum;
        }
        return maxSum;
    }
}
