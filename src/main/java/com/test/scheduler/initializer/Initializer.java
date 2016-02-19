package com.test.scheduler.initializer;

import com.test.scheduler.model.Activity;

import java.util.Collection;

/**
 * Interface for the initializer
 */
public interface Initializer {

   Collection<Activity> loadActivities();
}
