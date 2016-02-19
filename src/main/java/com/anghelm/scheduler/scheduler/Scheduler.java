package com.anghelm.scheduler.scheduler;

import com.anghelm.scheduler.model.Activity;
import com.anghelm.scheduler.model.Team;

import java.util.Collection;

/**
 * Interface for scheduler
 */
public interface Scheduler {

   Collection<Team> schedule(Collection<Activity> activities, int noOfTeams);
}
