package models;

public class BST {
    Node root;

    public BST() {
        root = null;
    }

    public Node getRootNode(){
        return root;
    }

    public void setRoot(Node node){
        root = node;
    }
    public void insert(int data) {
        root = insert(root, data);
    }

    
    public void display() {
        Node node = root;
        System.out.println("The right skewed tree : ");
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
        System.out.println();
    }

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

    public void inorder() {
        System.out.println("Inorder Traversal: ");
        inorder(root);
        System.out.println();
    }

    private void inorder(Node node) {
        if (node != null) {
            inorder(node.left);
            System.out.print(node.data + " ");
            inorder(node.right);
        }

    }

}
