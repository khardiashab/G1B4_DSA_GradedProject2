package main;

import java.util.Scanner;
import models.BST;
import service.Converter1;

/**
 * Driver is the main class that handles user input and executes the conversion of a Binary Search Tree (BST)
 * to a Right Skewed Binary Search Tree (BST).
 */
public class Driver {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the user
        Scanner scanner = new Scanner(System.in);

        // Create an instance of the Converter1 class
        Converter1 converter = new Converter1();

        // Create an instance of the BST class
        BST bst = new BST();

        // Prompt the user to enter the number of nodes in the BST
        System.out.println("Enter the number of nodes in the BST: ");

        // Read the number of nodes from the user
        int size = scanner.nextInt();

        // Loop to insert nodes into the BST
        for (int i = 0; i < size; i++) {
            // Prompt the user to enter a node
            System.out.println("Enter node " + (i + 1) + ": ");

            // Read the node from the user and insert it into the BST
            bst.insert(scanner.nextInt());
        }

        // Print the inorder traversal of the BST
        // System.out.println("Inorder traversal of the BST:");
        bst.inorder();

        // Convert the BST to a right-skewed BST
        bst.setRoot(converter.convertBstToRightSkewedBst(bst.getRootNode()));

        // Display the right-skewed BST
        // System.out.println("Right-skewed BST:");
        bst.display();

        // Close the Scanner object
        scanner.close();
    }
}