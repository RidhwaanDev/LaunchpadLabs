package com.ridhwaan.Launchpad.Firebase;

import com.ridhwaan.Launchpad.model.CourseModel;

import java.util.ArrayList;

/**
 * Created by Ridhwaan on 8/29/17.
 */

public class FireBaseUserModel {

    private String mUserName;
    private String mEmail;
    private String mPhoneNumber;
    private ArrayList<CourseModel> mCourseList;
    private int mClassesCompleted;

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

    public ArrayList<CourseModel> getmCourseList() {
        return mCourseList;
    }

    public void setmCourseList(ArrayList<CourseModel> mCourseList) {
        this.mCourseList = mCourseList;
    }

    public int getmClassesCompleted() {
        return mClassesCompleted;
    }

    public void setmClassesCompleted(int mClassesCompleted) {
        this.mClassesCompleted = mClassesCompleted;
    }
}
