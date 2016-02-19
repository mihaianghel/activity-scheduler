package com.anghelm.scheduler.util;

import com.anghelm.scheduler.algorithm.Item;
import com.anghelm.scheduler.model.Activity;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Helper class
 */
public final class Helper {

   private Helper() {}

   public static List<Item> convertActivitiesToItems(final Collection<Activity> activities) {
      final List<Item> items = new ArrayList();
      activities.stream()
            .forEach(a -> items.add(new Item(a.getName(), a.getDuration())));
      return items;
   }

   public static List<Activity> convertItemsToActivities(final List<Item> items) {
      final List<Activity> activities = new ArrayList();
      items.stream()
            .forEach(i -> activities.add(new Activity(i.getName(), i.getWeight())));
      return activities;
   }

   public static List<Item> filterUnselectedItems(final List<Item> items) {
      return items.stream().filter(i -> !i.isInKnapsack()).collect(Collectors.toList());
   }

   public static List<Item> filterSelectedItems(final List<Item> items) {
      return items.stream().filter(i -> i.isInKnapsack()).collect(Collectors.toList());
   }

   public static String formatDuration(final int duration) {
      return (duration == Constants.SPRINT_DURATION) ? Constants.SPRINT : duration + Constants.MIN;
   }

   public static String formatDate(final LocalTime time) {
      DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");
      return time.format(formatter).toLowerCase();
   }
}
