package service;

import java.util.LinkedList;

import models.BST;
import models.Node;

public class BSTToRSTWithStack {

    public void display(Node node) {
        System.out.println("The right skewed tree : ");
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
        System.out.println();
    }

    public void convert(BST bst) {

        Node root = null;
        Node temp = root;
        Node node = bst.getRootNode();
        if (node == null) {
            return;
        }
        LinkedList<Node> stack = new LinkedList<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            Node node2 = stack.pop();
            if (node2.left != null) {
                stack.push(node2.left);
            }
            if (node2.right != null) {
                stack.push(node2.right);
            }
            if (root != null) {
                temp.right = node2;
                temp = temp.right;
                temp.left = null;
            } else {
                root = node2;
                temp = root;
                temp.left = null;
            }

        }
        bst.setRoot(root);
    }


    public void convertWithInorderTraversal(BST bst){
        Node node = bst.getRootNode();
        Node prevNode = new Node(0);
        inorder(node, prevNode);
        bst.setRoot(prevNode.right);
    }

    private void inorder(Node node, Node prevNode) {
        if(node == null){
            return ;
        }
        inorder(node.left, prevNode);
        prevNode.right = node;
        inorder(node.right, prevNode);
    }
}
