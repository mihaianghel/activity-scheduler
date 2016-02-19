package com.anghelm.scheduler.initializer.impl;

import com.anghelm.scheduler.model.Activity;
import org.junit.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;


public class InitializerTest {

   private InitializerImpl initializer;

   @Test
   public void testActivitiesAreInitialized() {
      initializer = new InitializerImpl() {
         @Override
         protected List<String> readLinesFromFile() throws IOException {
            return Arrays.asList("Duck Hunting 30min", "Hide and Seek sprint");
         }
      };

      final Collection<Activity> activities = initializer.loadActivities();

      assertEquals(2, activities.size());
      for (Activity a : activities) {
         if (a.getName().equals("Duck Hunting")) {
            assertEquals(30, a.getDuration());
         } else if (a.getName().equals("Hide and Seek")) {
            assertEquals(15, a.getDuration());
         } else {
            fail();
         }
      }
   }

   @Test
   public void testActivitiesAreNotInitialized() {
      initializer = new InitializerImpl() {
         @Override
         protected List<String> readLinesFromFile() throws IOException {
            return Arrays.asList("Duck Hunting ABC", "H");
         }
      };

      final Collection<Activity> activities = initializer.loadActivities();

      assertTrue(activities.isEmpty());
   }

}