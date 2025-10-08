// a^3 + a^2 b + 2 a^2 b + 2 a b^2 + a b^2 + b^3

public class EquationValue {
    public static void main(String[] args) {
        System.out.println(solve(2, 3, 4));
    }

    private static long solve(int a, int b, int c) {
        return cube(a) + (square(a) * b) + (2 * square(a) * b) + (2 * a * square(b)) + (a * square(b)) + cube(b);
    }

    private static long cube(int n) {
        return n * n * n;
    }

    private static long square(int n) {
        return n * n;
    }
}
