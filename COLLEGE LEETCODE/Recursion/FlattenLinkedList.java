// https://www.geeksforgeeks.org/problems/flattening-a-linked-list/1

class FlattenLinkedList {

    static class Node {
        int data;
        Node next;
        Node bottom;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.bottom = null;
        }
    }

    Node flatten(Node root) {
        if (root == null || root.next == null) return root;
        root.next = flatten(root.next);
        root = helper(root, root.next);
        return root;
    }

    Node helper(Node l1, Node l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.data < l2.data) {
            l1.bottom = helper(l1.bottom, l2);
            return l1;
        } else {
            l2.bottom = helper(l1, l2.bottom);
            return l2;
        }
    }

    public static void main(String[] args) {
        FlattenLinkedList list = new FlattenLinkedList();

        Node root = new Node(5);
        root.bottom = new Node(7);
        root.bottom.bottom = new Node(8);
        root.bottom.bottom.bottom = new Node(30);

        root.next = new Node(10);
        root.next.bottom = new Node(20);

        root.next.next = new Node(19);
        root.next.next.bottom = new Node(22);
        root.next.next.bottom.bottom = new Node(50);

        root.next.next.next = new Node(28);
        root.next.next.next.bottom = new Node(35);
        root.next.next.next.bottom.bottom = new Node(40);
        root.next.next.next.bottom.bottom.bottom = new Node(45);

        Node flattenedList = list.flatten(root);

        System.out.println("Flattened linked list:");
        printList(flattenedList);
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.bottom;
        }
        System.out.println();
    }
}
