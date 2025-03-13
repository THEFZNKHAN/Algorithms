public class PowerRec {
    // Computes a^b for b >= 0 using binary exponentiation
    public static int power(int a, int b) {
        if (b == 0) {
            return 1;
        }
        int temp = power(a, b / 2);
        if (b % 2 == 0) {
            return temp * temp;
        } else {
            return a * temp * temp;
        }
    }
    
    public static void main(String[] args) {
        int a = 2;
        int b = 10;
        System.out.println(a + "^" + b + " = " + power(a, b));
        System.out.println("3^3 = " + power(3, 3));
    }
}
