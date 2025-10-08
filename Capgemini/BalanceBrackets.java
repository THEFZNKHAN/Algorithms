import java.util.Stack;

public class BalanceBrackets {
    public static void main(String[] args) {
        System.out.println(isBalance("({[]})"));
        System.out.println(isBalance("({[})"));
        System.out.println(isBalance("({[]})]"));
        System.out.println(isBalance("({[})"));
    }

    private static boolean isBalance(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isOpenBracket(c)) {
                switch (c) {
                    case '(' -> st.push(')');
                    case '[' -> st.push(']');
                    default -> st.push('}');
                }
            } else {
                if (st.isEmpty() ||st.peek() != c) return false;
                st.pop();
            }
        }

        return st.isEmpty();
    }

    private static boolean isOpenBracket(char c) {
        return c == '(' || c == '[' || c == '{';
    }
}
