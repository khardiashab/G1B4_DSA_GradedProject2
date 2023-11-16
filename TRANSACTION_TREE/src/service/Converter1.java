package service;

import models.Node;

/**
 * Converter1 is a class that converts a Binary Search Tree (BST) to a Right Skewed Binary Search Tree (BST).
 */
public class Converter1 {
    private Node previousNode;
    private Node root;

    /**
     * Constructor for Converter1.
     * Initializes the root node with a value of -1.
     * Sets the previous node as the root node.
     */
    public Converter1() {
        root = new Node(-1);
        previousNode = root;
    }

    /**
     * Converts a given BST to a Right Skewed BST.
     * @param node The root node of the BST.
     * @return The root node of the converted Right Skewed BST.
     */
    public Node convertBstToRightSkewedBst(Node node) {
        convertHelper(node);
        return root.right;
    }

    /**
     * Recursive helper method to convert the BST to a Right Skewed BST.
     * @param node The current node being processed.
     */
    private void convertHelper(Node node) {
        if (node == null) {
            return;
        }

        convertHelper(node.left);
        previousNode.right = node;
        previousNode = previousNode.right;
        convertHelper(node.right);
    }
}