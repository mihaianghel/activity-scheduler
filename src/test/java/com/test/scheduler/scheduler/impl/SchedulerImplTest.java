package com.test.scheduler.scheduler.impl;

import com.test.scheduler.model.Activity;
import com.test.scheduler.model.Team;
import com.test.scheduler.util.Constants;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

public class SchedulerImplTest {

   private SchedulerImpl scheduler = new SchedulerImpl();

   @Test
   public void testScheduling() {
      final Collection<Team> teams = scheduler.schedule(getActivities(), 2);
      assertEquals(2, teams.size());
      teams.stream().forEach(t -> {

         final int morningDuration = t.getMorningActivities()
               .stream()
               .map(Activity::getDuration)
               .reduce(0, (a, b) -> a+b);
         final int afternoonDuration = t.getAfternoonActivities()
               .stream()
               .map(Activity::getDuration)
               .reduce(0, (a, b) -> a+b);

         assertTrue(!t.getMorningActivities().isEmpty());
         assertTrue(!t.getAfternoonActivities().isEmpty());
         assertTrue(morningDuration <= Constants.MORNING_SESSION_DURATION);
         assertTrue(afternoonDuration <= Constants.TOTAL_DURATION_OF_THE_ACTIVITIES - morningDuration);
      });
   }

   private List<Activity> getActivities() {
      return Arrays.asList(new Activity("A1", 15), new Activity("A2", 45), new Activity("A3", 30),
            new Activity("A4", 60), new Activity("A5", 40), new Activity("A6", 30),
            new Activity("A7", 15), new Activity("A8", 60), new Activity("A9", 35),
            new Activity("B1", 60), new Activity("B2", 45), new Activity("B3", 45),
            new Activity("B4", 60), new Activity("B5", 60), new Activity("B6", 60),
            new Activity("B7", 15), new Activity("B8", 25), new Activity("B9", 30));
   }
}