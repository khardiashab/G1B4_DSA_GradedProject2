package main;

import java.util.Scanner;

import models.BST;
import service.BSTToRSTConverter;
import service.BSTToRSTWithStack;
import service.BstConverter;
import models.Node;

public class Driver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();
        BSTToRSTWithStack rst = new BSTToRSTWithStack();
        System.out.println("Enter the number of nodes in Bst: ");
        int size = sc.nextInt();
        
        while (size-- > 0) {
            System.out.println("Enter the node: ");
            bst.insert(sc.nextInt());
        }
        bst.inorder();
        rst.convert(bst);;
        bst.display();

        sc.close();
    }
}
