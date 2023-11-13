package service;

import models.Node;
public class BSTToRSTConverter {
    private Node prevNode;

    public void display(Node node) {
        System.out.println("The right skewed tree : ");
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.right;
        }
        System.out.println();
    }

    public Node convertBSTToRST(Node root) {
        prevNode = null;
        return convert(root);
    }
    

    private Node convert(Node node) {
        if (node == null) {
            return null;
        }

        Node right = convert(node.right);
        node.right = convert(node.left);
        node.left = null;

        if (prevNode != null) {
            prevNode.right = node;
        }

        prevNode = node;

        return right != null ? right : node;
    }
}
