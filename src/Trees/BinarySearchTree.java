package Trees;

public class BinarySearchTree {

    public class Node {
        int key;
        Node left, right ;

        public Node(int item){
            this.key = item;
            left = right = null;
        }
    }

    Node root;

    public BinarySearchTree(){
        root = null;
    }

    void insert(int item){
       root = insertNode(root, item);
    }

    Node insertNode(Node root, int key){

        if( root == null){
            root = new Node(key);
            return root;
        }

        if ( key < root.key){
            root.left = insertNode(root.left, key);
        }
        else {
            root.right = insertNode(root.right, key);
        }

        return root;
    }

    void delete(int key) {
        root = deleteRec(root, key);
    }

    Node deleteRec(Node root, int key){

        if(root == null){
            return root;
        }

        if( key < root.key){
            root.left = deleteRec(root.left, key);
        }
        else if (key > root.key){
            root.right = deleteRec(root.right, key);
        }
        else {

            if (root.left == null){
                return root.right;
            }
            else if (root.right == null){
                return root.left;
            }

            root.key = minval(root.right);

            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    public int minval(Node n){

        int key = n.key;

        while (n.left != null) {
            key = n.left.key;
            n = n.left;
        }

        return key;
    }

    void inorder()
    {
        inorderRec(root);
    }

    // A utility function to
    // do inorder traversal of BST
    void inorderRec(Node root)
    {
        if (root != null) {
            inorderRec(root.left);
            System.out.println(root.key);
            inorderRec(root.right);
        }
    }

    void preorder()
    {
        preorderRec(root);
    }

    // A utility function to
    // do inorder traversal of BST
    void preorderRec(Node root)
    {
        if (root != null) {
            System.out.println(root.key);
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    void postorder()
    {
        postorderRec(root);
    }

    // A utility function to
    // do inorder traversal of BST
    void postorderRec(Node root)
    {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.println(root.key);
        }
    }

    void printLeafNode(Node temp){
        if (temp == null){
            return;
        }
        if(temp.left == null && temp.right == null)
            System.out.println(temp.key);

        printLeafNode(temp.left);
        printLeafNode(temp.right);

    }
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();

        /* Let us create following BST
              50
           /     \
          30      70
         /  \    /  \
       20   40  60   80 */
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);

        System.out.println("Leaf node traversal ... ");
        tree.printLeafNode(tree.root);
        // print inorder traversal of the BST
        System.out.println("Inorder ... ");
        tree.inorder(); //LRoR

        System.out.println("Preorder ... ");
        tree.preorder(); //RoLR

        System.out.println("PostOrder ... ");
        tree.postorder(); //LRRo
    }
}
