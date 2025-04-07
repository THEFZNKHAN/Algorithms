
import java.util.Scanner;

public class Repetitions {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String s = sc.nextLine();
            int[] fq = new int[4];

            for (char c : s.toCharArray()) {
               switch (c) {
                   case 'A' -> fq[0]++;
                   case 'C' -> fq[1]++;
                   case 'G' -> fq[2]++;
                   case 'T' -> fq[3]++;
                   default -> throw new AssertionError();
               }
            }
            int max = 0;
            for (int i = 0; i < 4; i++) max = Math.max(fq[i], max);
            System.out.println(max);
        }
    }
}
