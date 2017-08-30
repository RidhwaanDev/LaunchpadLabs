package com.ridhwaan.Launchpad.Firebase;

import com.google.api.client.util.Data;
import com.google.firebase.database.DatabaseReference;

/**
 * Created by Ridhwaan on 8/29/17.
 */

public class FireBaseInit {

    public final static void init(){

        FireBaseManager firebaseHandler = new FireBaseManager();
        DatabaseReference courseReference = firebaseHandler.createRef("Courses");
        firebaseHandler.addEntry(courseReference," Programming ");
        firebaseHandler.addEntry(courseReference," Robotics ");
        firebaseHandler.addEntry(courseReference," SAT Prep ");
        firebaseHandler.addEntry(courseReference," Debate ");
        firebaseHandler.addEntry(courseReference," High school Math ");

        DatabaseReference userReference = firebaseHandler.createRef("Users");


    }




}
