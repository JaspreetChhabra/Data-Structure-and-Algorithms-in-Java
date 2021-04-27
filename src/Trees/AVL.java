package Trees;

class Node {
    int key, height;
    Node left, right;

    Node(int key) {
        this.key = key;
        this.height = 1;
    }
}

public class AVL {
    Node root;

    int height(Node n) {
        if (n == null)
            return 0;

        return n.height;
    }

    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    int getBalance(Node n){
        if (n == null)
            return 0;

        return height(n.left) - height(n.right);
    }

    //Left Left case
    Node rightRotate(Node Y) {
        Node x = Y.left;
        Node T2 = x.right;

        Y.left = T2;
        x.right = Y;

       Y.height = max(height(Y.left), height(Y.right)) + 1;
       x.height = max(height(x.left), height(x.right)) + 1;

       return x;
    }

    //Right right case
    Node leftRotate(Node z){
        Node y = z.right;
        Node T2 = y.left;

        y.left = z;
        z.right = T2;

        y.height = max(height(y.left), height(y.right)) + 1;
        z.height = max(height(z.left), height(z.right)) + 1;

        return y;
    }

    Node minValueNode(Node current){
        if (current == null)
            return null;

        while (current.left != null){
            current = current.left;
        }

        return current;
    }

    Node insertNode(Node node,  int key){

        if (node == null){
            return (new Node(key));
        }

        if(key < node.key){
            node.left = insertNode(node.left, key);
        }
        else if (key > node.key){
            node.right = insertNode(node.right, key);
        }
        else return node;

        node.height = 1 + max(height(node.left), height(node.right));

        int balance = getBalance(node);

        //left left case
        if (balance > 1 && key < node.left.key){
            return rightRotate(node);
        }

        //right right case
        if (balance < -1 && key > node.right.key){
            return leftRotate(node);
        }

        //left right case
        if (balance > 1 && key > node.left.key){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        //right left case
        if(balance < -1 && key < node.right.key){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    Node deleteNode(Node root, int key){

        if (root == null)
            return root;

        if(key < root.key){
            root.left = deleteNode(root.left, key);
        }
        else if (key > root.key){
            root.right = deleteNode(root.right, key);
        }
        else {

            if((root.left == null) || (root.right == null)){

                Node temp = null;
                if(root.left == null){
                    temp = root.right;
                }
                else{
                    temp = root.left;
                }

                if(temp == null){
                    temp = root;
                    root = null;
                }
                else {
                    root = temp;
                }
            }
            else {

                Node temp = minValueNode(root.right);

                root.key = temp.key;
                root.right = deleteNode(root.right, temp.key);
            }
        }

        if( root == null)
            return root;

        root.height = max(height(root.right), height(root.left)) + 1;

        int balance = getBalance(root);

        //left left case
        if (balance > 1 && key < root.left.key){
            return rightRotate(root);
        }

        //right right case
        if (balance < -1 && key > root.right.key){
            return leftRotate(root);
        }

        //left right case
        if (balance > 1 && key > root.left.key){
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        //right left case
        if(balance < -1 && key < root.right.key){
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }


    void preOrder(Node n) {
        if (n != null){
            System.out.println(n.key);
            preOrder(n.left);
            preOrder(n.right);
        }
    }

    public static void main(String[] args){
        AVL avl = new AVL();

        avl.root = avl.insertNode(avl.root, 10);
        avl.root = avl.insertNode(avl.root, 20);
        avl.root = avl.insertNode(avl.root, 30);
        avl.root = avl.insertNode(avl.root, 40);
        avl.root = avl.insertNode(avl.root, 50);
        avl.root = avl.insertNode(avl.root, 25);

        avl.preOrder(avl.root);

        avl.root = avl.deleteNode(avl.root, 30);

        System.out.println("DELETE");

        avl.preOrder(avl.root);
    }

}


