class Trie {
    class TrieNode {
        TrieNode[] child;
        boolean isEnd;
        int cntPrefix;
        int ctr;

        public TrieNode() {
            this.child = new TrieNode[26];
            this.isEnd = false;
            this.cntPrefix = 0;
            this.ctr = 0;
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
            return this.isEnd;
        }

        public void incrementCtr() {
            this.ctr++;
        }

        public void decrementCtr() {
            this.ctr--;
        }
        
        public int getCounter() {
            return ctr;
        }
        
        public void incrementPC() {
            this.cntPrefix++;
        }

        public void decrementPC() {
            this.cntPrefix--;
        }

        public int getPrefixCounter() {
            return cntPrefix;
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
            temp.incrementPC();
        }
        temp.setEnd();
        temp.incrementCtr();
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

    public int countWordEqualTo(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            if (!temp.containsKey(c)) return 0;
            temp.get(c);
        }
        return temp.getCounter();
    }

    public int countWordStartingWith(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            if (!temp.containsKey(c)) return 0;
            temp.get(c);
        }
        return temp.getPrefixCounter();
    }

    public void erase(String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            if (!temp.containsKey(c)) return;
            temp.decrementPC();
            temp.get(c);
        }
        temp.decrementCtr();
    }
}