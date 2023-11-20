/**
 * This class represents a Service for constructing buildings based on floor sizes.
 * The constructBuilding method takes an array of floor sizes as input and performs the construction work.
 */
package service;

import java.util.PriorityQueue;

public class Service {
    /**
     * Constructs buildings based on the given floor sizes.
     * 
     * @param floorSizes An array of floor sizes
     */
    public static void constructBuilding(int[] floorSizes) {
        if (floorSizes == null || floorSizes.length == 0) {
            System.out.println("No floors to construct.");
            return;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(floorSizes.length, (a, b) -> b - a);
        PriorityQueue<Integer> availableBlocks = new PriorityQueue<>(floorSizes.length, (a, b) -> b - a);

        // Add elements from floorSizes to maxHeap
        for (int i = 0; i < floorSizes.length; i++) {
            maxHeap.offer(floorSizes[i]);
        }

        System.out.println("The order of construction is as follows");
        System.out.println();

        // Process construction work for each day
        for (int i = 0; i < floorSizes.length; i++) {
            availableBlocks.offer(floorSizes[i]);
            String dayWork = dailyConstructionWork(maxHeap, availableBlocks);
            System.out.println("Day: " + (i + 1));
            System.out.println(dayWork);
        }
    }

    /**
     * Performs the daily construction work by removing blocks available in both maxHeap and availableBlocks.
     * 
     * @param maxHeap         PriorityQueue representing the maximum floor sizes
     * @param availableBlocks PriorityQueue representing the available blocks for construction
     * @return A string representing the construction work done for the day
     */
    private static String dailyConstructionWork(PriorityQueue<Integer> maxHeap,
                                                PriorityQueue<Integer> availableBlocks) {
        StringBuilder dayWork = new StringBuilder();

        // Remove blocks that are available in both maxHeap and availableBlocks
        while (!availableBlocks.isEmpty() && maxHeap.peek().equals(availableBlocks.peek())) {
            dayWork.append(availableBlocks.poll()).append(" ");
            maxHeap.poll();
        }

        return dayWork.toString();
    }
  
}