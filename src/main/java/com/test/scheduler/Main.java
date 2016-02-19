package com.test.scheduler;

import com.test.scheduler.initializer.Initializer;
import com.test.scheduler.model.Activity;
import com.test.scheduler.model.Team;
import com.test.scheduler.scheduler.Scheduler;
import com.test.scheduler.scheduler.impl.SchedulerImpl;
import com.test.scheduler.initializer.impl.InitializerImpl;

import java.time.LocalTime;
import java.util.Collection;

/**
 * Main driver of the class
 */
public class Main {

   private static final Initializer initializer = new InitializerImpl();
   private static final Scheduler scheduler = new SchedulerImpl();

   public static void main(String[] args) {

      final int nrOfTeams = readNrOfTeamsFromCommandLine();
      if (nrOfTeams != 0) {
         final Collection<Activity> activities = initializer.loadActivities();
         final Collection<Team> teams = scheduler.schedule(activities, nrOfTeams);
         printSchedule(teams);
      }
   }

   private static int readNrOfTeamsFromCommandLine() {
      try {
         System.out.print("Enter the number of participant teams (1 to 4): ");
         final String input = System.console().readLine();
         final int noOfTeams = Integer.parseInt(input);
         if (noOfTeams >= 1 && noOfTeams <= 4) {
            return noOfTeams;
         } else {
            System.out.println("Number of introduced teams is out of range");
            return 0;
         }
      } catch (NumberFormatException e) {
         System.out.println("Invalid value entered for the number of teams");
         return 0;
      }
   }

   private static void printSchedule(Collection<Team> teams) {
      int teamCounter = 1;
      for (Team t : teams) {
         System.out.println("Team" + teamCounter++);
         LocalTime startTime = NINE_AM;

         //Morning activities
         for (Activity a : t.getMorningActivities()) {
            System.out.println(formatDate(startTime) + " : " + a.getName() + " " + formatDuration(a.getDuration()));
            startTime = startTime.plusMinutes(a.getDuration());
         }

         //Lunch
         System.out.println(formatDate(startTime) + " : Lunch Break 60min");
         startTime = startTime.plusMinutes(60);

         //Afternoon activities
         for (Activity a : t.getAfternoonActivities()) {
            System.out.println(formatDate(startTime) + " : " + a.getName() + " " + formatDuration(a.getDuration()));
            startTime = startTime.plusMinutes(a.getDuration());
         }

         //Presentation
         if (startTime.isBefore(FOUR_PM)) {
            startTime = FOUR_PM;
         }
         System.out.println(formatDate(startTime) + " : Staff Motivation Presentation");
         System.out.println();
      }
   }
}
