class Pattern1 {
    public static void main(String[] args) {
        System.err.println("pattern for 2:");
        pattern(2);
        System.err.println("\n\npattern for 3:");
        pattern(3);
        System.err.println("\n\npattern for 4:");
        pattern(4);
        System.err.println("\n\npattern for 5:");
        pattern(5);
        System.err.println("\n\npattern for 6:");
        pattern(6);
    }

    public static void pattern(int n) {
        for (int i = 0; i < 3 * n; i++) {
            if (i < n) {
                System.err.println("@");
            } else if (i < 2 * n) {
                if (i == n) {
                    System.err.print("@");
                } else {
                    System.err.print(" ");
                }
                int t = (i % n);
                for (int j = 0; j < t * (n - 1); j++) {
                    System.err.print(" ");
                }

                for (int j = 0; j < n; j++) {
                    System.err.print("*");
                }

                if (i == 2 * n - 1) {
                    System.err.print("@");
                }

                System.err.println();
            } else {
                for (int j = 0; j < (n * n) - (n - 2); j++) {
                    System.err.print(" ");
                }
                System.err.println("@");
            }
        }
    }
}
