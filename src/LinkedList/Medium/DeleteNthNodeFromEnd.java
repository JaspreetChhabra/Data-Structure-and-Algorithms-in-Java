package LinkedList.Medium;

import LinkedList.LinkedList.Node;
import LinkedList.LinkedList;

public class DeleteNthNodeFromEnd {

    static int i=0;
    static Node prev, next;

    public static void NthFromLast(int n, Node head){

        if(head == null)
            return;

        NthFromLast(n, head.getNext());
        ++i;
        if(i == n-1)
            next = head;

        if(i == n+1)
            prev = head;
    }

    public static Node deleteNthNode(Node head, int n){

        if((head.getNext() != null && n ==1)){
            head.setNext(null);
            return head;
        }
        if((head.getNext() == null && n ==1))
            return null;


        NthFromLast(n, head);
        if(prev == null)
            head = next;
        if(next == null)
            prev.setNext(null);
        if(prev != null && next != null) {
            prev.setNext(next);
        }
        return head;
    }

    public static Node deleteNthNodeOptimised(Node head, int n){
        Node tempNode = new Node(0);
        tempNode.setNext(head);

        Node first = tempNode;
        Node second = tempNode;

        for (int i = 1; i<= n+1; i++){
            first = first.getNext();
        }

        while(first != null){
            first = first.getNext();
            second = second.getNext();
        }

        second.setNext(second.getNext().getNext());
        return tempNode.getNext();
    }

    public static void main(String[] args)
    {
        LinkedList linkedList = new LinkedList();

        linkedList.head = new Node(2);
        Node second = new Node(3);
        Node third = new Node(4);
        Node fourth = new Node(5);

        linkedList.head.setNext(second);
        second.setNext(third);
        third.setNext(fourth);
        System.out.println("Delete 2nd last Node: ");
        Node head = deleteNthNodeOptimised(linkedList.head, 2);
        LinkedList.traversal(head);
        System.out.println("Delete 2nd last Node: ");
        Node head1 = deleteNthNode(linkedList.head, 2);
        LinkedList.traversal(head1);
    }
}
