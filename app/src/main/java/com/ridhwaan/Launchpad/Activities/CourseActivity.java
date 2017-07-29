package com.ridhwaan.Launchpad.Activities;

import android.support.v4.app.Fragment;

import com.ridhwaan.Launchpad.Fragment.CourseFragment;
import com.ridhwaan.Launchpad.SingleFragmentActivity;

public class CourseActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return CourseFragment.newInstance();
    }



}
