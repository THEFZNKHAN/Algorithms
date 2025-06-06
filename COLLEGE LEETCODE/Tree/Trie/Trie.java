class Trie {
    class TrieNode {
        TrieNode[] child;
        boolean isEnd;

        public TrieNode() {
            child = new TrieNode[26];
            isEnd = false;
        }

        public boolean containsKey(char c) {
            return child[c - 'a'] != null;
        }

        public TrieNode get(char c) {
            return child[c - 'a'];
        }

        public void put(char c, TrieNode node) {
            child[c - 'a'] = node;
        }

        public void put(char c) {
            child[c - 'a'] = new TrieNode();
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            if (!temp.containsKey(c)) temp.put(c);
            temp.get(c); // temp = temp.child[c];
        }
        temp.setEnd();
    }

    public boolean search(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            if (!temp.containsKey(c)) return false;
            temp.get(c);
        }
        return temp.isEnd();
    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (char c : prefix.toCharArray()) {
            if (!temp.containsKey(c)) return false;
            temp.get(c);
        }
        return true;
    }
}