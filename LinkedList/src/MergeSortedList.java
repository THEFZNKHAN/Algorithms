class MergeSortedList {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(4);

        SinglyLinkedList list2 = new SinglyLinkedList();
        list2.insertAtEnd(1);
        list2.insertAtEnd(3);
        list2.insertAtEnd(4);
        
        Node result = new MergeSortedList().mergeTwoLists(list.head, list2.head);

        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
    }

    public Node mergeTwoLists(Node l1, Node l2) {
        Node dummy = new Node(-1);
        Node current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.data < l2.data) {
                current.next = new Node(l1.data);
                l1 = l1.next;
            } else {
                current.next = new Node(l2.data);
                l2 = l2.next;
            }
            current = current.next;
        }

        while (l1 != null) {
            current.next = new Node(l1.data);
            l1 = l1.next;
            current = current.next;
        }

        while (l2 != null) {
            current.next = new Node(l2.data);
            l2 = l2.next;
            current = current.next;
        }

        return dummy.next;
    }
}