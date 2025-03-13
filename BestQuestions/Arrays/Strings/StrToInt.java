class StrToInt {
    public static void main(String[] args) {
        String[] examples = {"   -42", "4193 with words", "words and 987", "-91283472332", "3.14159", "   +0 123"};
        for (String str : examples) {
            int result = myAtoi(str);
            System.out.println("Input: \"" + str + "\" => Output: " + result);
        }
    }

    public static int myAtoi(String str) {
        final int n = str.length();
        if (n == 0) return 0;

        int idx = 0;
        while (idx < n && str.charAt(idx) == ' ') idx++;
        if (idx == n) return 0;

        char ch;
        boolean isN = (ch = str.charAt(idx)) == '-';

        if (isN || ch == '+') ++idx;

        final int max = Integer.MAX_VALUE / 10;

        int ans = 0;
        while (idx < n && isDigit(ch = str.charAt(idx))) {
            int d = ch - '0';
            if (ans > max || (ans == max && d > 7)) {
                return isN ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = (ans * 10) + d;
            ++idx;
        }
        return isN ? -ans : ans;
    }

    private static boolean isDigit(char ch) {
        return ch >= '0' && ch <= '9';
    }
}