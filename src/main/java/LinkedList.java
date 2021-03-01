public class LinkedList {
    static Node head;

    static class Node{
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            next = null;
        }
    }

    static Node reverse(Node node){
        Node prev = null;
        Node current = node;
        Node next;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
    }

    void printList(Node node){
        while(node != null){
            System.out.println(node.value + " ");
            node = node.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.head = new Node(85);
        linkedList.head.next = new Node(15);
        linkedList.head.next.next = new Node(4);
        linkedList.head.next.next.next = new Node(20);
        linkedList.printList(head);
        head = reverse(head);
        System.out.println("Reversed: ");
        linkedList.printList(head);
    }

}
