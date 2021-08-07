package LinkedList.Easy;

//    Geeks https://www.geeksforgeeks.org/nth-node-from-the-end-of-a-linked-list/
//    Program for n’th node from the end of a Linked List

//    Given a Linked List and a number n, write a function that returns the value at the n’th node from the end of the Linked List.
//    For example, if the input is below list and n = 3, then output is “B”
//    A -> B -> C -> D -> Null

import LinkedList.LinkedList;
import LinkedList.LinkedList.Node;

public class NthNodeFromEnd {

    public static Node getNthNode(Node head, int n){
        Node slow = head;
        Node fast = head;

        int i =1;

        while (fast.getNext() != null){
            fast = fast.getNext();

            if(i > n-1){
                slow = slow.getNext();
            }
            i++;
        }
        return slow;
    }

    static int i=0;
    public static void printNthFromLast(int n, Node head){

        if(head == null)
            return;

        printNthFromLast(n, head.getNext());
        if(++i == n) {
            System.out.println(head.getKey());
        }
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

        System.out.println("Middle Element: "+ getNthNode(linkedList.head, 1).getKey());
        printNthFromLast(1, linkedList.head);
    }
}
