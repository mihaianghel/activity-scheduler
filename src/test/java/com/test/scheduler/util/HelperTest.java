package com.test.scheduler.util;

import com.test.scheduler.algorithm.Item;
import com.test.scheduler.model.Activity;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class HelperTest {

   @Test
   public void testConversionToItems() {
      final List<Item> items = Helper.convertActivitiesToItems(getActivities());

      assertEquals(2, items.size());
      for (Item i : items) {
         if (i.getName().equals("name A1")) {
            assertEquals(15, i.getWeight());
         } else if (i.getName().equals("name A2")) {
            assertEquals(25, i.getWeight());
         } else {
            fail();
         }
      }
   }

   @Test
   public void testConversionToActivities() {
      final List<Activity> activities = Helper.convertItemsToActivities(getItems());

      assertEquals(2, activities.size());
      for (Activity a : activities) {
         if (a.getName().equals("name I1")) {
            assertEquals(15, a.getDuration());
         } else if (a.getName().equals("name I2")) {
            assertEquals(25, a.getDuration());
         } else {
            fail();
         }
      }
   }

   @Test
   public void testFilterSelectedItems() {
      final List<Item> items = Helper.filterSelectedItems(getItems());

      assertEquals(1, items.size());
      assertEquals("name I1", items.iterator().next().getName());
      assertEquals(15, items.iterator().next().getWeight());
   }

   @Test
   public void testFilterUnselectedItems() {
      final List<Item> items = Helper.filterUnselectedItems(getItems());

      assertEquals(1, items.size());
      assertEquals("name I2", items.iterator().next().getName());
      assertEquals(25, items.iterator().next().getWeight());
   }

   @Test
   public void testFormatDurationToMins() {
      Assert.assertEquals("60min", Helper.formatDuration(60));
   }

   @Test
   public void testFormatDurationToSprint() {
      Assert.assertEquals(Constants.SPRINT, Helper.formatDuration(Constants.SPRINT_DURATION));
   }

   @Test
   public void testFormatDate() {
      Assert.assertEquals("12:00 pm", Helper.formatDate(LocalTime.NOON));
   }

   private List<Activity> getActivities() {
      return Arrays.asList(new Activity("name A1", 15),
                           new Activity("name A2", 25));
   }

   private List<Item> getItems() {
      final Item i = new Item("name I1", 15);
      i.setInKnapsack(true);
      return Arrays.asList(i, new Item("name I2", 25));
   }
}
