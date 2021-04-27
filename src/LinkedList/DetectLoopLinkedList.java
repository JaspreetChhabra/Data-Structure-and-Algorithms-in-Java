package LinkedList;

// Geeks https://www.geeksforgeeks.org/detect-loop-in-a-linked-list/

// LeetCode 141. https://leetcode.com/problems/linked-list-cycle/

// Given head, the head of a linked list, determine if the linked list has a cycle in it.
//
// There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
//
// Return true if there is a cycle in the linked list. Otherwise, return false.
//
// Example 1:
// Input: head = [3,2,0,-4], pos = 1
// Output: true
// Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).

public class DetectLoopLinkedList {

    class Node {
        int data;
        Node next;

        Node(){
            this.next = null;
        }
    }

    Node head;
    DetectLoopLinkedList() {
        this.head = null;
    }


    public void push(int data){

        Node node = new Node();
        node.data = data;
        node.next = head;
        head= node;
    }

    public boolean detectLoop(){
        Node first, second = null;

        if (this.head != null)
        {
            first = head;
            second = head;
        }
        else {
            return false;
        }

        while (second.next != null){
            first = first.next;
            second = second.next.next;

            if (first == second)
                return true;
        }

        return false;
    }

    public static void main(String[] args) {
        DetectLoopLinkedList detectLoopLinkedList = new DetectLoopLinkedList();

        detectLoopLinkedList.push(1);
        detectLoopLinkedList.push(2);
        detectLoopLinkedList.push(3);
        detectLoopLinkedList.push(4);
        detectLoopLinkedList.push(5);

        detectLoopLinkedList.head.next.next.next.next.next = detectLoopLinkedList.head;
        System.out.println("loop: " + detectLoopLinkedList.detectLoop());


    }
}


