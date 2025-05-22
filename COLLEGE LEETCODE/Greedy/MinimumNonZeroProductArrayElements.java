class MinimumNonZeroProductArrayElements {
    final int MOD = 1_000_000_007;

    public int minNonZeroProduct(int p) {
        long last = (1L << p) - 1;
        long res = (pow(last - 1, last / 2) * (last % MOD)) % MOD;
        return (int) res;
    }

    public long pow(long x, long n) {
        long res = 1;
        x = x % MOD;
        while (n > 0) {
            if ((n & 1) == 1) res = (res * x) % MOD;
            x = (x * x) % MOD;
            n >>= 1;
        }
        return res;
    }
}