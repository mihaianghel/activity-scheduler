package com.anghelm.scheduler.model;

import com.anghelm.scheduler.algorithm.Item;

/**
 * POJO representing an activity
 */
public class Activity extends Item {

   public Activity(String name, int duration) {
      super(name, duration);
   }

   public String getName() {
      return super.getName();
   }

   public int getDuration() {
      return super.getWeight();
   }

}
