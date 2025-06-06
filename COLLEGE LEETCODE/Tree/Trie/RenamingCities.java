class RenamingCities {
    static class TrieNode {
        TrieNode[] child;
        int pc, ctr;
        boolean isEnd;
        public TrieNode () {
            this.child = new TrieNode[26];
            this.pc = 0;
            this.isEnd = false;
            this.ctr = 0;
        }
    }

    static TrieNode root;

    public static void check(String[] arr, int n) {
        root = new TrieNode();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < n; i++) {
            String s = arr[i];
            TrieNode node = root;
            int len = 0;
            boolean f = false;

            for (int j = 0; j < s.length(); j++) {
                int index = s.charAt(j) - 'a';
                if (node.child[index] == null) {
                    node.child[index] = new TrieNode();
                    if (!f) {
                        len = j + 1;
                        f = true;
                    }
                }
                node = node.child[index];
                node.pc++;
            }

            node.isEnd = true;
            node.ctr++;

            if (node.ctr == 1) {
                if (f) ans.append(s.substring(0, len)).append("\n");
                else ans.append(s).append("\n");
            } else {
                ans.append(s).append(" ").append(node.ctr).append("\n");
            }
        }

        System.out.print(ans.toString());
    }
}
