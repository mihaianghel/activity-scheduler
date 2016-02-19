package com.anghelm.scheduler.scheduler.impl;

import com.anghelm.scheduler.algorithm.Item;
import com.anghelm.scheduler.util.Constants;
import com.anghelm.scheduler.algorithm.Knapsack;
import com.anghelm.scheduler.algorithm.KnapsackSolution;
import com.anghelm.scheduler.model.Activity;
import com.anghelm.scheduler.model.Team;
import com.anghelm.scheduler.model.Tracker;
import com.anghelm.scheduler.scheduler.Scheduler;
import com.anghelm.scheduler.strategy.StrategyContext;
import com.anghelm.scheduler.util.Helper;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Scheduler implementation
 */
public class SchedulerImpl implements Scheduler {

   private StrategyContext context = new StrategyContext(new Knapsack());

   private List<Item> remainingItemsAfterMorningSession;

   @Override
   public Collection<Team> schedule(final Collection<Activity> activities, final int noOfTeams) {

      final List<Item> initialListOfItems = Helper.convertActivitiesToItems(activities);

      final List<Tracker> morningTrackers = scheduleMorningActivities(initialListOfItems, noOfTeams);
      final List<Tracker> afternoonTrackers =
            scheduleAfternoonActivities(remainingItemsAfterMorningSession, morningTrackers);

      return afternoonTrackers.stream().map(Tracker::getTeam).collect(Collectors.toList());
   }

   private List<Tracker> scheduleMorningActivities(final List<Item> items, final int noOfTeams) {
      final List<Tracker> aggregator = new ArrayList();
      scheduleMorning(items, Constants.MORNING_SESSION_DURATION, aggregator, noOfTeams);
      return aggregator;
   }

   private void scheduleMorning(final List<Item> items,
                                final int duration,
                                final List<Tracker> aggregator,
                                int counter) {
      if (counter != 0) {
         final KnapsackSolution solution = (KnapsackSolution) context.executeStrategy(items, duration);
         final List<Item> selectedItems = Helper.filterSelectedItems(solution.getItems());
         final List<Item> remainingItems = Helper.filterUnselectedItems(solution.getItems());

         final Team t = new Team();
         t.setMorningActivities(Helper.convertItemsToActivities(selectedItems));

         aggregator.add(new Tracker(solution.getSolutionWeight(), t));

         remainingItemsAfterMorningSession = remainingItems;
         scheduleMorning(remainingItems, duration, aggregator, --counter);
      }
   }

   private List<Tracker> scheduleAfternoonActivities(final List<Item> items, final List<Tracker> trackers) {
      List<Item> remainingItems = items;
      for (Tracker t : trackers) {
         final int remainingTime = Constants.TOTAL_DURATION_OF_THE_ACTIVITIES - t.getDuration() - Constants.LUNCH_BREAK_DURATION;
         final KnapsackSolution solution = (KnapsackSolution) context.executeStrategy(remainingItems, remainingTime);
         final List<Item> afternoonItems = solution.getItems();
         final List<Item> selectedItems = Helper.filterSelectedItems(afternoonItems);
         remainingItems = Helper.filterUnselectedItems(afternoonItems);
         t.getTeam().setAfternoonActivities(Helper.convertItemsToActivities(selectedItems));
      }
      return trackers;
   }
}
