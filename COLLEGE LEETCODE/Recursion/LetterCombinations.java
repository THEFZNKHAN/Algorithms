import java.util.*;

class LetterCombinations {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter digits: ");
            String digits = scanner.nextLine();
            List<String> combinations = letterCombinations(digits);
            System.out.println("Letter combinations: " + combinations);
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) return list;
        Map<Character, String> map = new HashMap<>();
        values(map);
        helper(digits, 0, new StringBuilder(), list, map);
        return list;
    }

    private static void helper(String d, int idx, StringBuilder sb, List<String> list, Map<Character, String> map) {
        if (idx == d.length()) {
            list.add(sb.toString());
            return;
        }

        String curr = map.get(d.charAt(idx));
        for (int i = 0; i < curr.length(); i++) {
            sb.append(curr.charAt(i));
            helper(d, idx + 1, sb, list, map);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    private static void values(Map<Character, String> map) {
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }
}