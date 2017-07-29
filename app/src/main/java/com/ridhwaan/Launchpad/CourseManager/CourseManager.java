package com.ridhwaan.Launchpad.CourseManager;

import android.content.Context;

/**
 * Created by Ridhwaan on 3/15/2017.
 */

public class CourseManager {

    private static CourseManager ourManager;
    public static final String[] courses = new String[]{"Programming" , "Robotics", " SAT Prep" , "Debate" , "High school Math"};
   Context mContext;

    public static CourseManager getInstance(Context context) {

        if(ourManager == null){
            ourManager = new CourseManager(context);
        }
        return ourManager;

    }

    private CourseManager(Context c){
           this.mContext = c;
 ;

    }











}