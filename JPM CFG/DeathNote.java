import java.util.Scanner;

public class DeathNote {
    public static void main(String[] args) {
        String s;
        try (Scanner sc = new Scanner(System.in)) {
            s = sc.next();
        }

        int n = s.length();
        if (n == 0 || s.charAt(0) == '0') {
            System.out.println(0);
            return;
        }

        int prev_prev = 1, prev = 1;

        for (int i = 1; i < n; i++) {
            int current = 0;
            char curr = s.charAt(i);
            char prevChar = s.charAt(i - 1);

            if (curr != '0') current += prev;
            if (prevChar == '1' || (prevChar == '2' && curr <= '6')) current += prev_prev;

            prev_prev = prev;
            prev = current;

            if (prev == 0) break;
        }

        System.out.println(prev);
    }
}

/*
 * Problem Statement :
 * 
 * Ryuk, the Shinigami (God of death) had allowed Light Yagami, a school
 * student, to kill as many people as he can by using a death note. But writing
 * the names barely will allow other people to watch them. So he encrypts the
 * names using digits, where a means 1, b means 2 and so on upto z is 26. Now if
 * he gives numbers, there is a communication error because a number string can
 * be decrypted by the death note in various ways and eventually killing them
 * all. If everyone in the world has a unique name, for a given number, how many
 * people can die?
 * NOTE THAT: There is every possible name in the world with the 26 letters, and
 * capital or small letters is not a problem.
 * 
 * Input format:
 * A number stream denoting the first name’s encrypted version
 * 
 * Output Format:
 * Number of people dying by this.
 * 
 * Constraints:
 * 1<=stream length<=10^8
 * 
 * Sample Input: 1267
 * Sample Output: 3
 * Output Specification:Two people of the name azg and lfg die.
 */