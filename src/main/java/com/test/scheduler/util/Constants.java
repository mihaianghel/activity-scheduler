package com.test.scheduler.util;

import java.time.LocalTime;

/**
 * Class holding the constants used in the project
 */
public final class Constants {

   private Constants() { }

   public static final String DELIMITER = " ";

   public static final String MIN = "min";

   public static final String SPRINT = "sprint";

   public static final int SPRINT_DURATION = 15;

   public static final int MORNING_SESSION_DURATION = 3 * 60;

   public static final int TOTAL_DURATION_OF_THE_ACTIVITIES = 8 * 60;

   public static final int LUNCH_BREAK_DURATION = 60;

   public static final LocalTime FOUR_PM = LocalTime.NOON.plusHours(4);

   public static final LocalTime NINE_AM = LocalTime.NOON.minusHours(3);
}
