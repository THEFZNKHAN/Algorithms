import java.util.Scanner;

public class Copycat {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter the number of words: ");
            int n = sc.nextInt();
            sc.nextLine();

            for (int i = 0; i < n; i++) {
                System.out.print("Enter the word: ");
                String word = sc.nextLine();
                int len = word.length();
                int[] freq = new int[26];

                for (char c : word.toCharArray()) freq[c - 'a']++;

                int sum = 0;
                for (int j = 0; j < 26; j++) {
                    if (freq[j] > 0) {
                        int temp = 2 * freq[j] - len;
                        if (temp > 0) sum += temp;
                    }
                }
                System.out.println("Maximum difference: " + (len - sum));
            }
        }
    }
}


/*
Problem Statement :
Joe was copying from John in the exam. So, John told him to change the answers a little bit so that the examiner cannot find the fraud. But silly Joe in the way started to change all the answers that were needed. He shuffled the letters in each word in a way where the maximum number of letters were misplaced.
For a given word, find the maximum difference that Joe can generate between his answer and John’s answer.
Suppose John wrote “car” for an answer, Joe can write “acr” with difference 2, or “arc” with difference 3.

Note That: The letters are all in lowercase.

Input Format:
First line containing an integer n, number of words.
Then, n numbers of lines as the query words.

Output:
N number of lines with an integer each denoting possible maximum difference.

Sample Input:
4
abababa
bbj
kj
kk

Sample Output:
6
2
2
0
*/