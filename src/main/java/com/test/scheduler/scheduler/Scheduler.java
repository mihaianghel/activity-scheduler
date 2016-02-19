package com.test.scheduler.scheduler;

import com.test.scheduler.model.Activity;
import com.test.scheduler.model.Team;

import java.util.Collection;

/**
 * Interface for scheduler
 */
public interface Scheduler {

   Collection<Team> schedule(Collection<Activity> activities, int noOfTeams);
}
