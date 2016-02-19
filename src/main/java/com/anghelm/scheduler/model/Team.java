package com.anghelm.scheduler.model;

import java.util.List;

/**
 * POJO representing a team
 */
public class Team {

   private List<Activity> morningActivities;

   private List<Activity> afternoonActivities;

   public List<Activity> getAfternoonActivities() {
      return afternoonActivities;
   }

   public void setAfternoonActivities(List<Activity> afternoonActivities) {
      this.afternoonActivities = afternoonActivities;
   }

   public List<Activity> getMorningActivities() {
      return morningActivities;
   }

   public void setMorningActivities(List<Activity> morningActivities) {
      this.morningActivities = morningActivities;
   }
}
