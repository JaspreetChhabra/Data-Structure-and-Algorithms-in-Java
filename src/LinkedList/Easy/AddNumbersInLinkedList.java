package LinkedList.Easy;

//    Geeks: https://www.geeksforgeeks.org/sum-of-two-linked-lists/
//    Add two numbers represented by linked lists
//
//    Given two numbers represented by two linked lists, write a function that returns the sum list. The sum list is linked list representation of the addition of two input numbers. It is not allowed to modify the lists. Also, not allowed to use explicit extra space (Hint: Use Recursion).
//
//    Example :
//
//    Input:
//    First List: 5->6->3
//    Second List: 8->4->2
//    Output
//    Resultant list: 1->4->0->5

import java.util.Stack;

class Node{

    int data;
    Node next;

    Node (int data){
        this.data = data;
        this.next = null;
    }
}

public class AddNumbersInLinkedList {

    static Node head1, head2;

    public static Node addNumbers(Node head1, Node head2){

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> resultStack = new Stack<>();

        while (head1 != null){
            stack1.add(head1.data);
            head1 = head1.next;
        }

        while (head2 != null){
            stack2.add(head2.data);
            head2 = head2.next;
        }

        int carry =0;

        while (!stack1.isEmpty() && !stack2.isEmpty()){
            int sum = stack1.pop() + stack2.pop();

            if(carry != 0){
                sum += carry;
                carry =0;
            }

            while (sum / 10 > 0){
                carry = sum / 10;
                sum = sum % 10;
            }
            resultStack.add(sum);
        }

        while (!stack1.isEmpty()){
            resultStack.add(stack1.pop());
        }

        while (!stack2.isEmpty()){
            resultStack.add(stack2.pop());
        }

        return createLinkedList(resultStack);
    }

    private static Node createLinkedList(Stack<Integer> resultStack){
        Node head, head1;
        head = head1 = null;
        while (!resultStack.isEmpty()){

            if(head == null){
                head = new Node(resultStack.pop());
                head1 = head;
            }

            Node node = new Node(resultStack.pop());
            head1.next = node;
            head1 = head1.next;
        }

        return head;
    }

    private static void print(Node head){
        while (head != null){
            System.out.print(head.data);
            head = head.next;
        }
    }

    public static void main(String[] args){

        head1 = new Node(7);
        Node two = new Node(0);
        head1.next = two;
        Node three = new Node(2);
        two.next = three;
        Node four = new Node(3);
        three.next = four;

        head2 = new Node(5);
        Node l2Two = new Node(9);
        head2.next = l2Two;
        Node l2Three = new Node(4);
        l2Two.next = l2Three;

        print(addNumbers(head1, head2));
    }
}
