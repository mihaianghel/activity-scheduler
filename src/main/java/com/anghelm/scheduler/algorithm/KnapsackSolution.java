package com.anghelm.scheduler.algorithm;

import com.anghelm.scheduler.strategy.StrategySolution;

import java.util.List;

/**
 * POJO representing the solution of the Knapsack problem
 */
public class KnapsackSolution extends StrategySolution {

   private int solutionWeight;

   private List<Item> items;

   public KnapsackSolution(int solutionWeight, List<Item> items) {
      this.solutionWeight = solutionWeight;
      this.items = items;
   }

   public int getSolutionWeight() {
      return solutionWeight;
   }

   public List<Item> getItems() {
      return items;
   }
}
