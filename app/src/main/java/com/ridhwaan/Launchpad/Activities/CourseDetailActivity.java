package com.ridhwaan.Launchpad.Activities;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

import com.ridhwaan.Launchpad.Fragment.GeneralController;
import com.ridhwaan.Launchpad.SingleFragmentActivity;

/**
 * Created by Ridhwaan on 3/19/2017.
 */

public class CourseDetailActivity extends SingleFragmentActivity {

    public static final String ARG_SOUND_OBJ = CourseDetailActivity.class.getCanonicalName();

    @Override
    public Fragment createFragment() {
        return  GeneralController.newInstance();
    }

    public static Intent newInstance (Context packageContext){

        Intent i = new Intent(packageContext,CourseDetailActivity.class);

        return i;

    }

}
