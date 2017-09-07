package com.ridhwaan.Launchpad.Firebase;

import com.google.api.client.util.Data;
import com.google.firebase.database.DatabaseReference;
import com.ridhwaan.Launchpad.model.CourseModel;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by Ridhwaan on 8/29/17.
 */

public class FireBaseInit {

    public final static void init(){


        FireBaseManager firebaseHandler = new FireBaseManager();
        DatabaseReference courseReference = firebaseHandler.createRef("Courses");

        for (int i = 0; i < 5 ; i++) {
            CourseModel c = new CourseModel();
            c.setmCourseTitle( "Course" + i);
            c.setmCourseContent( " RANDOM COURSE" + i);

            HashMap<String,Object> map = new HashMap<>();
            map.put( c.getmCourseTitle() , c);

            firebaseHandler.addNewCourse(map);
        }


        DatabaseReference userReference = firebaseHandler.createRef("Users");
        DatabaseReference chatReference = firebaseHandler.createRef("Users");



    }




}
