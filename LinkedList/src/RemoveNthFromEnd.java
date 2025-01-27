public class RemoveNthFromEnd {
    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.insertAtEnd(1);
        sll.insertAtEnd(2);
        sll.insertAtEnd(3);
        sll.insertAtEnd(4);
        sll.insertAtEnd(5);

        sll.head = removeNthFromEnd(sll.head, 2);
        sll.printList();
    }

    private static Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node first = dummy, second = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;
        return dummy.next;
    }
}
