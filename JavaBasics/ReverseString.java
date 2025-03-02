class ReverseString {
    public static void main(String[] args) {
        String str = "HelloIamAString";
        System.out.println(reverse(str));
    }

    private static String reverse(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[chars.length - 1 - i];
            chars[chars.length - 1 - i] = temp;
        }
        return new String(chars);
    }
}
