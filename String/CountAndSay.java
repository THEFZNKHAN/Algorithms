class CountAndSay {
    public static void main(String[] args) {
        int n = 30;
        for (int i = 1; i < n; i++) System.out.println(countAndSay(i));
    }

    private static String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = count(result);
        }
        return result;
    }

    private static String count(String str) {
        int i = 0, n = str.length();
        StringBuilder sb = new StringBuilder();
        while (i < n) {
            int ctr = 1;
            char c = str.charAt(i);
            while (i < n - 1 && str.charAt(i + 1) == c) {
                ctr++;
                i++;
            }
            sb.append(ctr);
            sb.append(c);
            i++;
        }
        return sb.toString();
    }
}