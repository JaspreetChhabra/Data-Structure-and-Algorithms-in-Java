package Trees.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderBT {

    static class Node{
        int value;
        Node left, right;

        Node (int value){
            this.value = value;
        }
    }

    Node root;

    public void printLevelOrder(Node root){

        int h = getHeight(root);

        for (int i=1; i <= h; i++){
            printNode(root, i);
        }
    }

    public int getHeight(Node root){

        if(root == null)
            return 0;

        int lheight = getHeight(root.left);
        int rheight = getHeight(root.right);

        if (lheight > rheight)
            return lheight+1;
        else return rheight+1;
    }

    public void printNode(Node root, int level) { // 2 1

        if (root == null)
            return;
        if (level == 1){
            System.out.println(root.value);
        }
        else if (level > 1){
            System.out.println("Print LEFT: " + root.value + " Level: "+ level);
            printNode(root.left, level-1); //2 1
            System.out.println("Print RIGHT: " + root.value + " Level: "+ level);
            printNode(root.right, level-1);
        }
    }

    public static void main(String[] args) {
        LevelOrderBT levelOrderBT = new LevelOrderBT();
        Node rootNode = new Node(1);

        Node leftnode = new Node(2);
        rootNode.left = leftnode;

        Node rightnode = new Node(3);
        rootNode.right = rightnode;
        Node leftLnode = new Node(4);
        rootNode.left.left = leftLnode;

        Node leftRnode = new Node(5);
        rootNode.left.right = leftRnode;

        //levelOrderBT.printLevelOrder(rootNode);

        Queue<Node> queue = new LinkedList<>();
        levelOrderBT.printQueue(rootNode, queue);
    }

    public void printQueue(Node root, Queue queue){
        queue.add(root);

        while (!queue.isEmpty()) {
            Node tempNode = (Node) queue.poll();

            System.out.println(tempNode.value);
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }

}
