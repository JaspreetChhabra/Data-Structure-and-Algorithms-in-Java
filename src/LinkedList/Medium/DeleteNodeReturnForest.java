package LinkedList.Medium;

import java.util.Vector;

//    LeetCode https://leetcode.com/problems/delete-nodes-and-return-forest/
//
//    1110. Delete Nodes And Return Forest
//
//    Given the root of a binary tree, each node in the tree has a distinct value.
//
//    After deleting all nodes with a value in to_delete, we are left with a forest (a disjoint union of trees).
//
//    Return the roots of the trees in the remaining forest. You may return the result in any order.


public class DeleteNodeReturnForest {

    static class Node {
        int key;
        Node left;
        Node right;

        Node(int key) {
            this.key = key;
            this.left = null;
            this.right = null;
        }
    }

    Vector<Integer> subTreeRoots = null;

    private Vector<Integer> removeNode(Node root, int nodeToBeRemoved) {
        subTreeRoots = new Vector<>();
        getSubTreeRoots(root, nodeToBeRemoved, true);
        return subTreeRoots;
    }

    private Node getSubTreeRoots(Node node, int nodeToBeRemoved, boolean isRoot) {

        if (node == null) return null;

        boolean rootToBeDeleted = (node.key == nodeToBeRemoved);
        if (!rootToBeDeleted && isRoot) {
            subTreeRoots.add(node.key);
        }

        node.left = getSubTreeRoots(node.left, nodeToBeRemoved, rootToBeDeleted);
        node.right = getSubTreeRoots(node.right, nodeToBeRemoved, rootToBeDeleted);

        //return shouldDelete ? null : node;
        return node;
    }

    private static void inorderTraversal(Node root) {

        if (root == null) return;
        System.out.print(" " + root.key);
        inorderTraversal(root.left);
        inorderTraversal(root.right);
    }

    public static void main(String args[]) {
        DeleteNodeReturnForest deleteNodeReturnRoot = new DeleteNodeReturnForest();

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.right = new Node(6);
        root.right.right.left = new Node(7);

        System.out.println("Inorder Traversal");
        inorderTraversal(root);

        System.out.println("\nvector of roots of subtrees formed after removing the given node : ");
        deleteNodeReturnRoot.removeNode(root, 2).forEach(System.out::println);

        System.out.println("\nvector of roots of subtrees formed after removing the given node : ");
        deleteNodeReturnRoot.removeNode(root, 1).forEach(System.out::println);

        System.out.println("\nvector of roots of subtrees formed after removing the given node : ");
        deleteNodeReturnRoot.removeNode(root, 6).forEach(System.out::println);
    }
}