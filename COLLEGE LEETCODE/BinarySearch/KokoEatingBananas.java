public class KokoEatingBananas {

    public static void main(String[] args) {
        KokoEatingBananas koko = new KokoEatingBananas();
        
        int[] piles1 = {3, 6, 7, 11};
        int h1 = 8;
        System.out.println("Minimum eating speed for piles1: " + koko.minEatingSpeed(piles1, h1)); // 4

        int[] piles2 = {30, 11, 23, 4, 20};
        int h2 = 5;
        System.out.println("Minimum eating speed for piles2: " + koko.minEatingSpeed(piles2, h2)); // 30

        int[] piles3 = {30, 11, 23, 4, 20};
        int h3 = 6;
        System.out.println("Minimum eating speed for piles3: " + koko.minEatingSpeed(piles3, h3)); // 23
    }

    public int minEatingSpeed(int[] piles, int h) {
        int s = 1, e = 0;
        for (int n : piles) {
            e = Math.max(e, n);
        }

        while (s < e) {
            int mid = s + (e - s) / 2;
            int t = 0;
            for (int n : piles) {
                t += (n + mid - 1) / mid;
            }

            if (t <= h) {
                e = mid; 
            }else {
                s = mid + 1;
            }
        }
        return s;
    }
}