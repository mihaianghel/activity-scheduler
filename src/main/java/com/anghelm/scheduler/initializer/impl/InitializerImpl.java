package com.anghelm.scheduler.initializer.impl;

import com.anghelm.scheduler.initializer.Initializer;
import com.anghelm.scheduler.model.Activity;
import com.anghelm.scheduler.util.Constants;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *  Initializer implementation
 */
public class InitializerImpl implements Initializer {

   @Override
   public Collection<Activity> loadActivities() {

      final List<Activity> activities = new ArrayList();

      try {
         final List<String> lines = readLinesFromFile();
         lines.stream().
               forEach(l -> activities.add(new Activity(extractName(l), extractDuration(l))));
      } catch (Exception e) {
         System.out.println("Activities could not be loaded");
      }

      return activities;
   }

   protected List<String> readLinesFromFile() throws IOException {
      final List<String> lines = new ArrayList();

      final BufferedReader br = new BufferedReader(
            new InputStreamReader(InitializerImpl.class.getClassLoader().getResourceAsStream("activities.txt")));

      String strLine;

      while ((strLine = br.readLine()) != null) {
         lines.add(strLine);
      }

      br.close();

      return lines;
   }

   private String extractName(final String line) {
      return line.substring(0, line.lastIndexOf(Constants.DELIMITER));
   }

   private int extractDuration(final String line) {
      final String duration = line.substring(line.lastIndexOf(Constants.DELIMITER) + 1);
      if (Constants.SPRINT.equals(duration)) {
         return 15;
      } else {
         return Integer.parseInt(duration.substring(0, duration.indexOf(Constants.MIN)));
      }
   }
}
