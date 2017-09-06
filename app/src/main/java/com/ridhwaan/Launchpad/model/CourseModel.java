package com.ridhwaan.Launchpad.model;

import java.io.Serializable;
import java.util.HashMap;

/**
 * Created by Ridhwaan on 8/1/17.
 */

public class CourseModel implements Serializable {

    private String mCourseTitle;
    private String mCourseInstructorName;
    private String mCourseInstructorEmail;
    private String mCourseContent;
    private String mUpdates;



    public String getmCourseTitle() {
        return mCourseTitle;
    }

    public void setmCourseTitle(String mCourseTitle) {
        this.mCourseTitle = mCourseTitle;
    }

    public String getmCourseInstructorName() {
        return mCourseInstructorName;
    }

    public void setmCourseInstructorName(String mCourseInstructorName) {
        this.mCourseInstructorName = mCourseInstructorName;
    }

    public String getmCourseInstructorEmail() {
        return mCourseInstructorEmail;
    }

    public void setmCourseInstructorEmail(String mCourseInstructorEmail) {
        this.mCourseInstructorEmail = mCourseInstructorEmail;
    }

    public String getmUpdates() {
        return mUpdates;
    }

    public void setmUpdates(String mUpdates) {
        this.mUpdates = mUpdates;
    }

    public String getmCourseContent() {
        return mCourseContent;
    }

    public void setmCourseContent(String mCourseContent) {
        this.mCourseContent = mCourseContent;
    }


}
