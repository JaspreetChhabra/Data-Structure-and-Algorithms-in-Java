package Trees;

public class ArrayImplementationOfTree {

    static int root = 0;
    static String[] binaryTree = new String[10];

    public void addRoot(String key)
    {
        binaryTree[0] = key;
    }

    public void addLeftChild(String key, int root){

        if(binaryTree[root] == null){
            System.out.println("Cannot add left child as root is null");
            return;
        }

        int leftChild = (root * 2) + 1;
        binaryTree[leftChild] = key;
        System.out.println("Left child Key : " + key + " index: "+ leftChild);
    }

    public void addRightChild(String key, int root){

        if(binaryTree[root] == null){
            System.out.println("Cannot add right child as root is null");
            return;
        }

        int leftChild = (root * 2) + 2;
        binaryTree[leftChild] = key;
        System.out.println("Right child Key : " + key + " index: "+ leftChild);
    }

    public void printTree(){
        for (int i = 0; i < 10; i++) {
            if (binaryTree[i] != null)
                System.out.print(binaryTree[i]);
            else
                System.out.print("-");
        }
    }

    public static void main(String[] args){
        ArrayImplementationOfTree tree = new ArrayImplementationOfTree();

        tree.addRoot("A");
        tree.addRightChild("C", 0);
        tree.addLeftChild("D", 1);
        tree.addRightChild("E", 1);
        tree.addLeftChild("F", 2);
        tree.printTree();
    }
}
