package com.ridhwaan.Launchpad.Firebase;

import com.ridhwaan.Launchpad.model.CourseModel;
import com.ridhwaan.Launchpad.model.CourseModelStore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Ridhwaan on 8/29/17.
 */

public class FireBaseUserModel implements Serializable {

    private String mUserName;
    private String mEmail;
    private String mPhoneNumber;
    private HashMap<String,CourseModel> mCourseList;
    private int mClassesCompleted;
    private UUID mID;

    public HashMap<String, CourseModel> getmCourseList() {
        return mCourseList;
    }

    public void setmCourseList(HashMap<String, CourseModel> mCourseList) {
        this.mCourseList = mCourseList;
    }

    public FireBaseUserModel(){
        mID = UUID.randomUUID();
    }


    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public int getmClassesCompleted() {
        return mClassesCompleted;
    }

    public void setmClassesCompleted(int mClassesCompleted) {
        this.mClassesCompleted = mClassesCompleted;
    }

    public void addCourse(String course, CourseModel courseModel){

        if(mCourseList == null){
            mCourseList = new HashMap<>();
        }

        mCourseList.put(course,courseModel);
    }

    public UUID getmID() {
        return mID;
    }


}
