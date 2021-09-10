package LinkedList.Easy;

//    https://leetcode.com/problems/remove-duplicates-from-sorted-list/
//    LeetCode 83. Remove Duplicates from Sorted List
//
//    Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.
//
//    Example 1:
//
//
//    Input: head = [1,1,2]
//    Output: [1,2]

public class DeleteDuplicatesSortedLinkedList {

    private Node removeDuplicate(Node head){
        if(head == null || head.next == null) return head;
        head.next = removeDuplicate(head.next);
        return head.data == head.next.data ? head.next : head;
    }

    public static void main(String[] args){

        Node head = new Node(1);
        Node node1 = new Node(1);
        head.next = node1;
        Node node2 = new Node(1);
        node1.next = node2;
        Node node3 = new Node(1);
        node2.next = node3;
        Node node4 = new Node(1);
        node3.next = node4;
        Node node5 = new Node(1);
        node4.next = node5;

        DeleteDuplicatesSortedLinkedList d = new DeleteDuplicatesSortedLinkedList();
        System.out.println(d.removeDuplicate(head).data);
    }
}
