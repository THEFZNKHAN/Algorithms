public class CharCount {
    public static void main(String[] args) {
        String str = "aabbbbeeeeffggg";
        System.out.println(countChar(str));
    }

    private static String countChar(String str) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        char x = str.charAt(0);
        for (char c : str.toCharArray()) {
            if (c != x) {
                sb.append(x).append(cnt);
                x = c;
                cnt = 1;
            } else {
                cnt++;
            }
        }

        sb.append(x).append(cnt);
        return sb.toString();
    }
}
