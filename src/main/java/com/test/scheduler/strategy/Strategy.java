package com.test.scheduler.strategy;

import com.test.scheduler.algorithm.Item;

import java.util.List;

/**
 * Interface for the strategy pattern
 */
public interface Strategy {

   StrategySolution solve(List<Item> items, int weight);
}
