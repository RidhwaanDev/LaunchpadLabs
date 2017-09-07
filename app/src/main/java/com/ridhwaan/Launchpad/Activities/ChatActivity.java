package com.ridhwaan.Launchpad.Activities;

import android.support.v4.app.Fragment;

import com.ridhwaan.Launchpad.Fragment.ChatFragment;
import com.ridhwaan.Launchpad.SingleFragmentActivity;
import com.ridhwaan.Launchpad.model.CourseBreakDownModel;

/**
 * Created by Ridhwaan on 9/7/17.
 */

public class ChatActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return ChatFragment.newInstance();
    }



}
