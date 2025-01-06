import java.util.Scanner;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strings;

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of strings: ");
            int n = scanner.nextInt();
            scanner.nextLine();

            strings = new String[n];
            for (int i = 0; i < n; i++) {
                System.out.print("Enter string " + (i + 1) + ": ");
                strings[i] = scanner.nextLine();
            }
        }

        String result = findLongestCommonPrefix(strings);
        System.out.println("Longest Common Prefix: " + result);
    }

    public static String findLongestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }

        return prefix;
    }
}
