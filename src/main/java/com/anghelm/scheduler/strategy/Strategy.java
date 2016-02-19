package com.anghelm.scheduler.strategy;

import com.anghelm.scheduler.algorithm.Item;

import java.util.List;

/**
 * Interface for the strategy pattern
 */
public interface Strategy {

   StrategySolution solve(List<Item> items, int weight);
}
