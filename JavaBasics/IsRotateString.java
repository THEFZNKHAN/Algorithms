class IsRotateString {
    public static void main(String[] args) {
        System.out.println(isRotateString("waterbottle", "erbomtlewat"));
        System.out.println(isRotateString("waterbottle", "erbottlewat"));
        System.out.println(isRotateString("waterbottle", "erbotlewat"));
    }

    private static boolean isRotateString (String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        String t = s1 + s1;
        return t.contains(s2);
    }
}