// https://leetcode.com/problems/group-anagrams/description/

import java.util.*;

class GroupAnagram {
    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = groupAnagrams(strs);
        for (List<String> group : result) System.out.println(group);
    }

    // MORE OPTIMIZED (USING HASHING)
    static int[] primes = { 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 
        41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103 };

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int key = 1;
            for (char c : s.toCharArray()) key *= primes[c - 'a'];

            if (map.containsKey(key)) map.get(key).add(s);
            else {
                List<String> value = new ArrayList<>();
                value.add(s);
                map.put(key, value);
                res.add(value);
            }
        }
        return res;
    }

    // OPTIMIZED
    public List<List<String>> groupAnagrams_1(String[] strs) {
        Map<String,List<String>> ans=new HashMap<>();
        for(String str:strs){
            char[] ch=str.toCharArray();
            Arrays.sort(ch);
            String sorted=new String(ch);
            ans.putIfAbsent(sorted,new ArrayList<>());
            ans.get(sorted).add(str);
        }
        return new ArrayList<>(ans.values());
    }

    // BRUTE FORCE (SPACE OPTIMIZED)
    public static List<List<String>> groupAnagrams_2(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        String[] st = strs.clone();

        for (int i = 0; i < strs.length; i++) st[i] = sortStr(st[i]);


        List<String> temp = new ArrayList<>();
        int[] read = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            if (read[i] == 1) continue;
            temp.add(strs[i]);
            for (int j = i + 1; j < strs.length; j++) {
                if (read[j] == 1) continue;
                if (st[i].equals(st[j])) {
                    temp.add(strs[j]);
                    read[j] = 1;
                }
            }
            list.add(temp);
            temp = new ArrayList<>();
        }
        return list;
    }

    private static String sortStr(String s) {
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
    }
}