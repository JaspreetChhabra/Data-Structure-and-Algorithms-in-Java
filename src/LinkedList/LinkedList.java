package LinkedList;

public class LinkedList {

    public Node head;
    public static class Node {
        int key;
        Node next = null;

        public Node (int key){
            this.key = key;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void traversal(Node n){
        if (n != null){
            System.out.println(n.key + " ");
            traversal(n.next);
        }
    }
    public static void main(String[] args)
    {
        LinkedList linkedList = new LinkedList();

        linkedList.head = new Node(2);
        Node second = new Node(3);
        Node third = new Node(4);

        linkedList.head.next = second;
        second.next = third;

        //Print
        traversal(linkedList.head);
    }
}
