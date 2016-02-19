package com.anghelm.scheduler.initializer;

import com.anghelm.scheduler.model.Activity;

import java.util.Collection;

/**
 * Interface for the initializer
 */
public interface Initializer {

   Collection<Activity> loadActivities();
}
