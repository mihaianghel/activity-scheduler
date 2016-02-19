package com.anghelm.scheduler.algorithm;

import com.anghelm.scheduler.util.Helper;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class KnapsackTest {

   private Knapsack knapsack = new Knapsack();

   @Test
   public void testTheAlgorithmWorks() {
      final KnapsackSolution solution = knapsack.solve(getListOfItems(), 10);

      assertNotNull(solution);
      assertEquals(10, solution.getSolutionWeight());
      final List<Item> items = solution.getItems();
      assertEquals(8, items.size());
      final List<Item> selectedItems = Helper.filterSelectedItems(items);
      assertTrue(selectedItems.size() == 6);
   }

   private List<Item> getListOfItems() {
      return Arrays.asList(new Item("i1", 4), new Item("i2", 3),
            new Item("i3", 3), new Item("i4", 2), new Item("i5", 1),
            new Item("i6", 1), new Item("i7", 1), new Item("i8", 1));
   }


}
