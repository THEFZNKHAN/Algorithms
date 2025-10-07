public class ReverseBits {
    public static void main(String[] args) {
        int n = 11;
        System.out.println(reverseBits(n));
    }

    private static int reverseBits(int n) {
        int rev = 0;
        while (n > 0) {
            rev = (rev << 1) | (n & 1);
            n >>= 1;
        }
        return rev;
    }
}
