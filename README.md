Activity Scheduler
=====================

##Summary

This application is an implementation of an activity scheduler. The list of activities is provided through a text
file and the application schedules the activities during the day for a number of teams selected by the user.


##Approach
The application first loads the activities from the text file provided in the src/main/resources folder and
schedules the activities based on their duration and the time constraints. The assumptions that have been made
are the following:
* Two teams cannot have the same activities.
* The number of teams is variable (up to four).
* Lunch break and afternoon presentation (start between 4pm and 5pm) will not be necessarily in the same time for 
all the teams, depending on the duration of the pre-configured activities.
* If there are not enough activities provided, some teams might not have the entire day filled. But as the requirement
states, there are plenty of ideas so this shouldn't be a constraint.
* All the activities have the same priority/importance.


##Build and start the app
For bootstrapping the app you need Java 8 JDK and Maven 3.
Using Maven, build the application with the following command:
```
mvn clean install
```
and then run the application by typing
```
java -jar target/activity-scheduler-1.0-SNAPSHOT-jar-with-dependencies.jar
```

##Notes
The solving algorithm allows extension so that the activities could be prioritised.