package models;

/**
 * BST (Binary Search Tree) is a class that represents a binary search tree data structure.
 */
public class BST {
    Node root;

    /**
     * Constructor for BST class.
     * Initializes the root node as null.
     */
    public BST() {
        root = null;
    }

    /**
     * Get the root node of the BST.
     * @return The root node.
     */
    public Node getRootNode(){
        return root;
    }

    /**
     * Set the root node of the BST.
     * @param node The new root node.
     */
    public void setRoot(Node node){
        root = node;
    }

    /**
     * Insert a new node with the given data into the BST.
     * @param data The data of the new node to be inserted.
     */
    public void insert(int data) {
        root = insert(root, data);
    }

    /**
     * Display the right-skewed tree.
     */
    public void display() {
        Node node = root;
        System.out.println("The right skewed tree : ");
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
        System.out.println();
    }

    /**
     * Recursive helper method to insert a new node into the BST.
     * @param node The current node being processed.
     * @param data The data of the new node to be inserted.
     * @return The updated node after insertion.
     */
    private Node insert(Node node, int data) {
        if (node == null) {
            node = new Node(data);
        } else {
            if (data < node.data) {
                node.left = insert(node.left, data);
            } else {
                node.right = insert(node.right, data);
            }
        }
        return node;
    }

    /**
     * Perform an inorder traversal of the BST and print the elements.
     */
    public void inorder() {
        System.out.println("Inorder Traversal: ");
        inorder(root);
        System.out.println();
    }

    /**
     * Recursive helper method to perform inorder traversal of the BST.
     * @param node The current node being processed.
     */
    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }
    }
}