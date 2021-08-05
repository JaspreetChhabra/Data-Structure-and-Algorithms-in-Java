package LinkedList.Easy;

import java.util.HashSet;
import java.util.Set;

public class LinkedListsIntersection {

    private static Node head1, head2;
    static class Node{
        int key;
        Node next;

        public Node(int key) {
            this.key = key;
        }
    }

    public static Node intersectionNode(Node head1, Node head2){
        Set<Node> nodeSet = new HashSet<>();

        while (head1.next != null){
            nodeSet.add(head1);
            head1 = head1.next;
        }

        while (head2.next != null){
            if(nodeSet.contains(head2))
                return head2;

            head2 = head2.next;
        }

        return null;
    }

    public static Node intersectionNodeWithoutExtraSpace(Node head1, Node head2){
        Node p1 = head1;
        Node p2 = head2;

        while (p1 != p2){
            p1 = p1 == null ? head2 : p1.next;
            p2 = p2 == null ? head1 : p2.next;
        }

        return p1;
    }

    public static void traverse(Node head){
        while (head != null){
            System.out.print(head.key + " ");
            head = head.next;
        }
    }

    public static void main(String[] args){
        LinkedListsIntersection l1 = new LinkedListsIntersection();
        l1.head1 = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);
        Node node3 = new Node(4);

        l1.head1.next = node1;
        node1.next = node2;
        node2.next = node3;

        LinkedListsIntersection l2 = new LinkedListsIntersection();
        l2.head2 = new Node(1);
        Node node4 = new Node(0);

        l1.head2.next = node4;
        node4.next = node1;

        System.out.println("LL 1");
        traverse(head1);
        System.out.println("\nLL 2");
        traverse(head2);
        System.out.println("\nIntersection Point");
        System.out.println(intersectionNodeWithoutExtraSpace(head1, head2).key);
    }
}
