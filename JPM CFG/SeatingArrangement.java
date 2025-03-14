import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SeatingArrangement {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                int a = sc.nextInt();
                Queue<String> q = new LinkedList<>();
                q.add("1");
                for (int j = 1; j < a; j++) {
                    String v = q.poll();
                    q.add(v + "0");
                    if (v.endsWith("0")) {
                        q.add(v + "1");
                        j++;
                    }
                }
                while (q.size() > 1) q.poll();
                System.out.println(q.poll());
            }
        }
    }
}


/*
 * Problem Statement :
 * Semester exams are going on for university students. Examiners noticed that a
 * group of people are trying to cheat. They marked students of that group as
 * ‘1’ and students of another group ( who are not cheating ) as ‘0’
 * We can reduce cheating by not allowing students from group 1 to sit together,
 * means no two students from group 1 can sit together. Seatings are marked
 * using above conditions. Your task is to give the seating placement of nth
 * possibility Possibility order from 1 to 10 is given below
 * 
 * [1 10 100 101 1000 1001 1010 10000 10001 10010]
 * 
 * Sample input :
 * 3 → number of test cases
 * 4
 * 6
 * 9
 * 
 * Sample output :
 * 101
 * 1001
 * 10001
 * 
 * Explanation :
 * 4th possibility is 101
 * 6th possibility is 1001
 * 9th possibility is 10001
 */