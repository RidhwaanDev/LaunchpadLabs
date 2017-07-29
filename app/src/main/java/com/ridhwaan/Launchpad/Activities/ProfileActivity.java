package com.ridhwaan.Launchpad.Activities;

import android.support.v4.app.Fragment;

import com.ridhwaan.Launchpad.Fragment.ProfileFragment;
import com.ridhwaan.Launchpad.SingleFragmentActivity;

public class ProfileActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment() {
        return ProfileFragment.newInstance();
    }
}
