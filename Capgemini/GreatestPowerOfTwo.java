public class GreatestPowerOfTwo {
    public static void main(String[] args) {
        System.out.println(helper(10));
        System.out.println(helperBitwise(10));
        System.out.println(helper(100));
        System.out.println(helperBitwise(100));
        System.out.println(helper(70));
        System.out.println(helperBitwise(70));
        System.out.println(helper(500));
        System.out.println(helperBitwise(500));
        System.out.println(helper(5));
        System.out.println(helperBitwise(5));
        System.out.println(helper(64));
        System.out.println(helperBitwise(64));
    }

    private static int helper(int n) {
        int ans = 1;
        while (ans <= n) {
            ans <<= 1;
        }
        return (ans >> 1);
    }

    private static int helperBitwise(int n) {
        if (n <= 0) return 0;
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        n |= n >> 16; 
        
        return (n + 1) >> 1; 
    }
}
