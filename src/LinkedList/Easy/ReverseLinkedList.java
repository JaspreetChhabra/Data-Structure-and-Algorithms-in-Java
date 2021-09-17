package LinkedList.Easy;

//    https://leetcode.com/problems/reverse-linked-list/
//    LeetCode 206. Reverse Linked List
//
//    Given the head of a singly linked list, reverse the list, and return the reversed list.
//
//    Input: head = [1,2,3,4,5]
//    Output: [5,4,3,2,1]

public class ReverseLinkedList {

    private static Node reverseLinkedList(Node head){

        Node pre = null;
        Node curr = head;

        while(curr != null){
            Node temp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = temp;
        }

        return pre;
    }

    public static void main(String[] args){

        Node head = new Node(1);
        Node one = new Node(2);
        head.next = one;
        Node two = new Node(3);
        one.next = two;
        Node three = new Node(4);
        two.next = three;
        Node four = new Node(5);
        three.next = four;

        System.out.println(reverseLinkedList(head).data);
    }
}
