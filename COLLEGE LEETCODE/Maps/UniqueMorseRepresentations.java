import java.util.HashSet;
import java.util.Set;

public class UniqueMorseRepresentations {
    public static void main(String[] args) {
        String[] words1 = {"gin", "zen", "gig", "msg"};
        System.out.println("Test Case 1: " + uniqueMorseRepresentations(words1));

        String[] words2 = {"a", "b", "c", "d"};
        System.out.println("Test Case 2: " + uniqueMorseRepresentations(words2));

        String[] words3 = {"hello", "world", "leetcode"};
        System.out.println("Test Case 3: " + uniqueMorseRepresentations(words3));

        String[] words4 = {"aaa", "aaa", "aaa"};
        System.out.println("Test Case 4: " + uniqueMorseRepresentations(words4));
    }

    static String[] code = {".-","-...","-.-.","-..",".","..-.","--.","....","..",
    ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-",
    "...-",".--","-..-","-.--","--.."};

    public static int uniqueMorseRepresentations(String[] words) {
        Set<String> set = new HashSet<>();
        for (String w : words) set.add(morseCode(w));
        return set.size();
    }

    private static String morseCode(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) sb.append(code[c - 'a']);
        return sb.toString();
    }
}
