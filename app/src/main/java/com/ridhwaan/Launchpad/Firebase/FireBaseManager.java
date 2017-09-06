package com.ridhwaan.Launchpad.Firebase;

import android.content.Context;
import android.util.Log;

import com.google.api.client.util.Data;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.ridhwaan.Launchpad.model.CourseModel;
import com.squareup.otto.Bus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
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



    public void addNewCourse( HashMap<String,Object> course){
        DatabaseReference ref = getDataBase().getReference().child("Courses");
        ref.updateChildren(course);
    }

    public static ArrayList<CourseModel> recieveData(ArrayList<CourseModel> list){
        return list;
    }


    public DatabaseReference getCourseRef(){
        DatabaseReference ref = getDataBase().getReference().child("Courses");
        return ref;
    }


    public void publishCourseList (Context c) {

        DatabaseReference ref = getDataBase().getReference().child("Courses");
        FireBaseManager.FireBaseDataListener childEventListener = new FireBaseManager.FireBaseDataListener(c);
        ref.addChildEventListener(childEventListener);

    }

    protected class FireBaseDataListener implements  ChildEventListener {
        final ArrayList<CourseModel> list = new ArrayList<>();
        protected boolean isComplete = false;
        private float count = 0;

        private FireBaseSession session;

        public FireBaseDataListener ( Context c ){
            session = FireBaseSession.getInstance(c);

        }

        @Override
        public void onChildAdded(DataSnapshot dataSnapshot, String s) {
            count++;

            if(count >= dataSnapshot.getChildrenCount()) {
                session.publishEvent(list);
                isComplete = true;
                return;
            }
            CourseModel c = dataSnapshot.getValue(CourseModel.class);
            list.add(c);


        }

        @Override
        public void onChildChanged(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onChildRemoved(DataSnapshot dataSnapshot) {

        }

        @Override
        public void onChildMoved(DataSnapshot dataSnapshot, String s) {

        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }

        protected ArrayList<CourseModel> getList(){
            if (isComplete) {
                return  list;
            }
            return null;
        }
    }






}
