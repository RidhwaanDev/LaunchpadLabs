package com.ridhwaan.Launchpad.Firebase;

import android.content.Context;
import android.util.Log;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ridhwaan.Launchpad.model.CourseModel;

import java.util.HashMap;
import java.util.Objects;

/**
 * Created by Ridhwaan on 7/29/17.
 */

public class FireBaseManager {


    DatabaseReference ref = getDataBase().getReference().child("Users");

    public static FirebaseDatabase getDataBase(){
        FirebaseDatabase  fbdb = FirebaseDatabase.getInstance();
        return  fbdb;
    }


    public DatabaseReference createRef(String key){

        DatabaseReference ref = getDataBase().getReference().child(key);
        return ref;

    }

    public void addEntry(DatabaseReference reference, String value){
        reference.push().setValue(value);

    }

    public void addModelEntry(DatabaseReference reference, Object obj){

        if(obj instanceof  FireBaseUserModel) {

            FireBaseUserModel userModel = ((FireBaseUserModel) obj);
            reference.child(userModel.getmID().toString()).setValue(obj);
            DatabaseReference subRef = reference.child(userModel.getmID().toString()).child("Course Ref");

        }

        if(obj instanceof CourseModel){
            CourseModel courseModel = ((CourseModel) obj);
            reference.setValue(courseModel);
        }
    }

    public void addUser( FireBaseUserModel user){

        addModelEntry(ref, user);
    }

    public void updateUserCourseList(String id, String where, HashMap<String,Object> updateCourseList){

        DatabaseReference ref = getDataBase().getReference().child("Users").child(id).child(where);
        ref.updateChildren(updateCourseList);
    }

    public void addCourse( CourseModel course,Context c){

        FireBaseSession session = FireBaseSession.getInstance(c);

        DatabaseReference ref = getDataBase().getReference().child("Users").child(session.getSession().getmID().toString());
        addModelEntry(ref, course);
    }

}
