package service;

import models.Node;

public class BstConverter {
    Node prevNode;

    public void display(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        display(root.right);
    }

    public Node method(Node root) {
        prevNode = null;
        return convert(root);
    }

    public Node convert(Node node) {
        if (node == null) {
            return null;
        }
        Node leftreturn = convert(node.left);
        
        node.right = convert(node.right);
        node.left = null;
        if (prevNode != null) {
            prevNode.right = node;
        }
        
        if (prevNode.right != null) {
            return prevNode.right;
        } else {
            return prevNode;
        }
    }

}
