package com.anghelm.scheduler.algorithm;

/**
 * Generic item included in the algorithm
 */
public class Item {

   private final String name;
   private final int weight;
   private boolean inKnapsack = false;

   public Item(String name, int weight) {
      this.name = name;
      this.weight = weight;
   }

   public String getName() {
      return name;
   }

   public int getWeight() {
      return weight;
   }

   public int getValue() {
      return 1;
   }

   public boolean isInKnapsack() {
      return inKnapsack;
   }

   public void setInKnapsack(boolean inKnapsack) {
      this.inKnapsack = inKnapsack;
   }

}
