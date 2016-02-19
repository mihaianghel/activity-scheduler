package com.anghelm.scheduler.model;

/**
 * POJO representing a tracker for each team
 */
public class Tracker {

   private int duration;

   private Team team;

   public Tracker(int duration, Team team) {
      this.duration = duration;
      this.team = team;
   }

   public int getDuration() {
      return duration;
   }

   public Team getTeam() {
      return team;
   }
}
