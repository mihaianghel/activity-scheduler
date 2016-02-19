package com.test.scheduler.algorithm;

import com.test.scheduler.strategy.Strategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Class containing the dynamic approach for solving the knapsack problem
 */
public class Knapsack implements Strategy {

   @Override
   public KnapsackSolution solve(final List<Item> items, final int maxWeight) {

      int solutionWeight = 0;
      final int noOfItems = items.size();

      if (noOfItems > 0 && maxWeight > 0) {

         final List<List<Integer>> holder = new ArrayList();
         List<Integer> current = new ArrayList();

         holder.add(current);

         for (int j = 0; j <= maxWeight; j++) {
            current.add(0);
         }

         for (int i = 1; i <= noOfItems; i++) {
            final List<Integer> previous = current;
            holder.add(current = new ArrayList());

            for (int j = 0; j <= maxWeight; j++) {
               if (j > 0) {
                  final int wH = items.get(i - 1).getWeight();
                  current.add((wH > j) ?
                        previous.get(j) : Math.max(previous.get(j), items.get(i - 1).getValue() + previous.get(j - wH)
                  ));
               } else {
                  current.add(0);
               }
            }

         }

         for (int i = noOfItems, j = maxWeight; i > 0 && j >= 0; i--) {
            final int temp1 = holder.get(i).get(j);
            final int temp2 = holder.get(i - 1).get(j);
            if ((i == 0 && temp1 > 0) || (i > 0 && temp1 != temp2)) {
               final Item item = items.get(i - 1);
               final int tempWeight = item.getWeight();
               item.setInKnapsack(true);
               j -= tempWeight;
               solutionWeight += tempWeight;
            }
         }
      }

      return new KnapsackSolution(solutionWeight, items);
   }
}
