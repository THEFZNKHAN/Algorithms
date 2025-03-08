public class FruitIntoBaskets {
    public static void main(String[] args) {
        int[] fruits = {1, 2, 1, 2, 3, 2, 2, 2};
        int result = totalFruit(fruits);
        System.out.println("Maximum number of fruits in two baskets: " + result);
    }

    // BEATS 99.46% of TC
    public static int totalFruit(int[] fruits) {
        int t1 = -1, t2 = -1, i1 = 0, i2 = 0, max = 0, i = 0;
        for (int j = 0; j < fruits.length; j++) {
            if (t1 == -1) {
                t1 = fruits[j];
                i1 = j;
            } else if (fruits[j] == t1) {
                i1 = j;
            } else if (t2 == -1) {
                t2 = fruits[j];
                i2 = j;
            }  else if (fruits[j] == t2){
                i2 = j;
            } else {
                if (i1 < i2) {
                    i = i1 + 1;
                    i1 = j;
                    t1 = fruits[j];
                } else {
                    i = i2 + 1;
                    i2 = j;
                    t2 = fruits[j];
                }
            }
            if (j - i + 1 > max) max = j - i + 1;
        }
        return max;
    }
}
