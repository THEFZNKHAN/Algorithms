// https://leetcode.com/problems/check-if-number-is-a-sum-of-powers-of-three/

class CheckPowersOfThree {

    public static void main(String[] args) {
        System.out.println(checkPowersOfThree(12)); // true
        System.out.println(checkPowersOfThree(91)); // true
        System.out.println(checkPowersOfThree(21)); // false
    }

    private static boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) {
                return false;
            }
            n /= 3;
        }

        return true;
    }
}
