class Trie {
    class TrieNode {
        TrieNode[] arr;
        boolean isEnd;

        public TrieNode() {
            arr = new TrieNode[26];
            isEnd = false;
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        int n = word.length();
        TrieNode temp = root;
        for (int i = 0; i < n; i++) {
            int idx = word.charAt(i) - 'a';
            if (temp.arr[idx] == null)
                temp.arr[idx] = new TrieNode();
            temp = temp.arr[idx];
        }
        temp.isEnd = true;
    }

    public boolean search(String word) {
        int n = word.length();
        TrieNode temp = root;
        for (int i = 0; i < n; i++) {
            int idx = word.charAt(i) - 'a';
            if (temp.arr[idx] == null)
                return false;
            temp = temp.arr[idx];
        }
        return temp.isEnd;
    }

    public boolean startsWith(String word) {
        int n = word.length();
        TrieNode temp = root;
        for (int i = 0; i < n; i++) {
            int idx = word.charAt(i) - 'a';
            if (temp.arr[idx] == null)
                return false;
            temp = temp.arr[idx];
        }
        return true;
    }
}