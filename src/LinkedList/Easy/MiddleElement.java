package LinkedList.Easy;

import LinkedList.LinkedList;
import LinkedList.LinkedList.Node;

//    Leetcode: 876. Middle of the Linked List https://leetcode.com/problems/middle-of-the-linked-list/
//
//    Given the head of a singly linked list, return the middle node of the linked list.
//
//    If there are two middle nodes, return the second middle node.
//
//    Example 1:
//
//    Input: head = [1,2,3,4,5]
//    Output: 3
//    Explanation: The middle node of the list is node 3.

public class MiddleElement {
    public static int middleNode(Node head) {
        Node slow, fast;
        slow = fast = head;

        if(head != null){
            while(fast != null && fast.getNext() != null ){
                slow = slow.getNext();
                fast = fast.getNext().getNext();
            }
        }

        return slow.getKey();
    }

    public static void main(String[] args)
    {
        LinkedList linkedList = new LinkedList();

        linkedList.head = new Node(2);
        Node second = new Node(3);
        Node third = new Node(4);

        linkedList.head.setNext(second);
        second.setNext(third);

        System.out.println("Middle Element: "+ middleNode(linkedList.head));
    }
}
