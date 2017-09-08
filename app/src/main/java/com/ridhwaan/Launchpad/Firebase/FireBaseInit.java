package com.ridhwaan.Launchpad.Firebase;

import com.google.api.client.util.Data;
import com.google.firebase.database.DatabaseReference;
import com.ridhwaan.Launchpad.model.CourseModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

/**
 * Created by Ridhwaan on 8/29/17.
 */

public class FireBaseInit {

    public final static void init() {


        FireBaseManager firebaseHandler = new FireBaseManager();
        DatabaseReference courseReference = firebaseHandler.createRef("Courses");

      /*  for (int i = 0; i < 5 ; i++) {
            CourseModel c = new CourseModel();
            c.setmCourseTitle( "Course" + i);
            c.setmCourseContent( " RANDOM COURSE" + i);

            HashMap<String,Object> map = new HashMap<>();
            map.put( c.getmCourseTitle() , c);

            firebaseHandler.addNewCourse(map);
        }*/

        ArrayList<CourseModel> data = new ArrayList<>();

        CourseModel c = new CourseModel();
        c.setmCourseTitle("Programming");
        c.setmCourseContent("Learn the fundamental building blocks of code" );

        CourseModel c1 = new CourseModel();
        c1.setmCourseTitle("15 for 15");
        c1.setmCourseContent("Learning for everyone. Add your school!");

        CourseModel c2 = new CourseModel();
        c2.setmCourseTitle("Robotics" );
        c2.setmCourseContent("Get started with arduino");

        CourseModel c3 = new CourseModel();
        c3.setmCourseTitle("SAT Prep");
        c3.setmCourseContent("Beat the test");

        data.add(c);
        data.add(c1);
        data.add(c2);
        data.add(c3);

        for (CourseModel course: data) {

            HashMap<String, Object> map = new HashMap<>();
            map.put(course.getmCourseTitle(), course);

            firebaseHandler.addNewCourse(map);
        }


        DatabaseReference userReference = firebaseHandler.createRef("Users");
        DatabaseReference chatReference = firebaseHandler.createRef("Chat");


    }

}
