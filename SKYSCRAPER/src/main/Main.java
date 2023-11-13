package main;

import java.util.*;

import service.Service;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the total number of floors in the building");
        int numberOfFloors = sc.nextInt();
        int[] floorSizes = new int[numberOfFloors];
        for (int i = 0; i < numberOfFloors; i++) {
            System.out.println("Enter the floor size given on day: " + (i + 1));
            floorSizes[i] = sc.nextInt();
        }
        Service.constructBuilding(floorSizes);
        sc.close();
    }
}
