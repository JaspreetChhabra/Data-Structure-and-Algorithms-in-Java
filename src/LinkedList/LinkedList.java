package LinkedList;

public class LinkedList {

    Node head;
    public static class Node {
        int key;
        Node next = null;

        public Node (int key){
            this.key = key;
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

        String s = new String("Gaurav");
        s = "Jaspreet";
        System.out.println(s);
    }
}
