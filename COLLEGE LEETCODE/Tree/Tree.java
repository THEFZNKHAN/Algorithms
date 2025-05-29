
import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    Node root;

    public static void main(String[] args) {
        Tree tree = new Tree();
        int[] arr = new int[]{2, 8, 1, 5, 3, 6, 12};
        for (int a : arr) tree.insert(a);

        System.out.print("In Order: ");
        tree.inOrder(tree.root);
        System.out.print("\nPre Order: ");
        tree.preOrder(tree.root);
        System.out.print("\nPost Order: ");
        tree.postOrder(tree.root);
        System.out.print("\nBFS Traversal:\n");
        tree.bfs(tree.root);
        System.out.println("\nSearching:");
        System.out.println(tree.search(tree.root, 3));
        System.out.println(tree.search(tree.root, 10));
        System.out.println(tree.search(tree.root, 12));
    }

    private void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) root.left = insertRec(root.left, data);
        else if (data > root.data) root.right = insertRec(root.right, data);
        return root;
    }

    private void inOrder(Node root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.data + " ");
            inOrder(root.right);
        }
    }

    private void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    private void postOrder(Node root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.data + " ");
        }
    }

    private void bfs(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.remove();
                if (temp.left != null) queue.add(temp.left);
                if (temp.right != null) queue.add(temp.right);
                System.out.print(temp.data + " ");
            }
            System.out.println();
        }
    }

    private boolean search(Node root, int t) {
        if (root == null) return false;
        if (root.data == t) return true;
        if (root.data > t) return search(root.left, t);
        return search(root.right, t);
    }
}

// spiral (zig-zag traversal)
// reverse spiral