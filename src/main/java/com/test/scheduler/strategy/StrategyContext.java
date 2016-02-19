package com.test.scheduler.strategy;

import com.test.scheduler.algorithm.Item;

import java.util.List;

/**
 * Strategy context which triggers the execution of the strategy/algorithm
 */
public class StrategyContext {

   private final Strategy strategy;

   public StrategyContext(final Strategy strategy) {
      this.strategy = strategy;
   }

   public StrategySolution executeStrategy(final List<Item> item, final int weight) {
      return strategy.solve(item, weight);
   }
}
