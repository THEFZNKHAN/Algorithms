import java.util.*;

class FindAnagrams {
    public static void main(String[] args) {
        FindAnagrams fa = new FindAnagrams();
        String s = "cbaebabacd";
        String p = "abc";
        List<Integer> result = fa.findAnagrams(s, p);
        System.out.println(result);
    }

    // MORE OPTIMIZED (100x Faster than BF)
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int n = s.length(), m = p.length();
        if (m > n) return list;

        int[] fq = new int[26];
        for (char c : p.toCharArray()) fq[c - 'a']++;

        int count = m;
        char[] c = s.toCharArray();
        for (int i = 0; i < m; i++) {
            if (fq[c[i] - 'a'] > 0) count--;
            fq[c[i] - 'a']--;
        }
        if (count == 0) list.add(0);

        for (int i = m; i < n; i++) {
            if (fq[c[i] - 'a'] > 0) count--;
            fq[c[i] - 'a']--;

            int left = c[i - m] - 'a';
            fq[left]++;
            if (fq[left] > 0) count++;

            if (count == 0) list.add(i - m + 1);
        }

        return list;
    }

    // OPTIMIZED USING HASHMAP AND SLIDING WINDOWS (10x Faster than BF)
    public List<Integer> findAnagrams_1(String s, String p) {
        int l1 = s.length(), l2 = p.length();
        if (l2 > l1) return new ArrayList<>();

        List<Integer> list = new ArrayList<>();

        HashMap<Character, Integer> hm = new HashMap<>();
        for (char c : p.toCharArray()) hm.put(c, hm.getOrDefault(c, 0) + 1);

        HashMap<Character, Integer> temp = new HashMap<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < l1; i++) {
            temp.put(c[i], temp.getOrDefault(c[i], 0) + 1);
            if (i >= l2) {
                if (temp.get(c[i - l2]) > 1) temp.put(c[i - l2], temp.get(c[i - l2]) - 1);
                else temp.remove(c[i - l2]);
            }
            if (hm.equals(temp)) list.add(i - l2 + 1);
        }
        return list;
    }

    // BRUTE FORCE
    public List<Integer> findAnagrams_2(String s, String p) {
        int[] fq = new int[26];
        for (char c : p.toCharArray()) fq[c - 'a']++;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s.length() - p.length() + 1; i++) {
            if (check(s, fq, i, i + p.length())) {
                list.add(i);
            }
        }
        return list;
    }

    private boolean check(String s, int[] fq, int l, int r) {
        int[] temp = fq.clone();
        for (int i = l; i < r; i++) {
            temp[s.charAt(i) - 'a']--;
            if (temp[s.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}