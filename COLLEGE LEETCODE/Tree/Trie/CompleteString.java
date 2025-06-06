
class CompleteString {
    class TrieNode {
        TrieNode[] child;
        boolean isEnd;

        public TrieNode() {
            this.child = new TrieNode[26];
            this.isEnd = false;
        }

        public boolean containsKey(char c) {
            return child[c - 'a'] == null;
        }

        public TrieNode get(char c) {
            return child[c - 'a'];
        }

        public void put(char c) {
            child[c - 'a'] = new TrieNode();
        }

        public void setEnd() {
            this.isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode temp = root;
            for (char c : word.toCharArray()) {
                if (!temp.containsKey(c))
                    temp.put(c);
                temp.get(c);
            }
            temp.setEnd();
        }

        public boolean search(String s) {
            TrieNode temp = root;
            for (char c : s.toCharArray()) {
                temp.get(c);
                if (!temp.isEnd()) return false;
            }
            return true;
        }
    }

    public String completeString(int n, String[] strs) {
        Trie trie = new Trie();

        for (String s : strs)
            trie.insert(s);

        String ans = "";

        for (String s : strs) {
            if (trie.search(s)) {
                if (s.length() > ans.length()) ans = s;
                else if (s.length() == ans.length() && s.compareTo(ans) < 0) ans = s;
            }
        }

        return ans.equals("") ? "None" : ans;
    }
}