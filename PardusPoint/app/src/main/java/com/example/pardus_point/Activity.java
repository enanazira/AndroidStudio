package com.example.pardus_point;

public class Activity {
    String activityName;
    String activityMarks;
    int tv1,tv2;

    public Activity(String name, String marks) {
        this.activityName = name;
        this.activityMarks = marks;
    }

    public String getName() {
        return activityName;

    }

    public void setName(String name) {
        this.activityName = name;
    }


    public String getActivityMarks() {
        return activityMarks;
    }

    public void setActivityMarks(String activityMarks) {
        this.activityMarks = activityMarks;
    }
}
