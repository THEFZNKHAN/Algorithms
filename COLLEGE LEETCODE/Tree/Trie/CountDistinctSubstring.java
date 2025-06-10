class CountDistinctSubstring {
    public static class Trie {
        Trie[] child;

        public Trie() {
            child = new Trie[26];
        }
        
        public boolean containsKey(char c) {
            return child[c - 'a'] != null;
        }
        
        public void put(char c) {
            child[c - 'a'] = new Trie();
        }
        
        public Trie get(char c) {
            return child[c - 'a'];
        }
    }

    public static int countDistinctSubstring(String st) {
        Trie root = new Trie();
        int n = st.length();
        char[] ch = st.toCharArray();

        int ctr = 1;
        for (int i = 0; i < n; i++) {
            Trie temp = root;
            for (int j = i; j < n; j++) {
                if (!temp.containsKey(ch[j])) {
                    temp.put(ch[j]);
                    ctr++;
                }
                temp = temp.get(ch[j]);
            }
        }
        return ctr;
    }
}