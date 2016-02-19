package com.test.scheduler.strategy;


import com.test.scheduler.algorithm.Item;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class StrategyContextTest {

   @Test
   public void testStrategyIsExecuted() {
      final StrategyContext context = new StrategyContext(getMockStrategy());

      final MockSolution sol = (MockSolution) context.executeStrategy(Arrays.asList(new Item("name", 10)), 20);

      assertEquals(21, sol.getSolution());
   }

   private Strategy getMockStrategy() {
      return (items, weight) -> new MockSolution(items, weight);
   }

   private class MockSolution extends StrategySolution {

      private List<Item> items;

      private int weight;

      private MockSolution(List<Item> items, int weight) {
         this.items = items;
         this.weight = weight;
      }

      private int getSolution() {
         return items.size() + weight;
      }

   }

}