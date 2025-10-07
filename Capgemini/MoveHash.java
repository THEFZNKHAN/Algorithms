public class MoveHash {
    public static void main(String[] args) {
        String str = "Move#Hash#to#Front";
        System.out.println(moveHash(str));
    }

    private static String moveHash(String str) {
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (char c : str.toCharArray()) {
            if (c != '#') sb.append(c);
            else cnt++;
        }
        StringBuilder hash = new StringBuilder();
        while (cnt-- > 0) hash.append('#');
        return hash.append(sb).toString();
    }
}