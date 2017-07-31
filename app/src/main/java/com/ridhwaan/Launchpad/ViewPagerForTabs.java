package com.ridhwaan.Launchpad;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.ridhwaan.Launchpad.Fragment.CourseFragment;
import com.ridhwaan.Launchpad.Fragment.ProfileFragment;

/**
 * Created by Ridhwaan on 6/20/17.
 */

public class ViewPagerForTabs extends FragmentPagerAdapter {

    static final String local = "Courses ";
    static final String drive = "Profile ";
    private static final String[] tabs = {local,drive};
    static final int tabsize = 2;

    public ViewPagerForTabs(FragmentManager fm){
                super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){

            case 0:
                return new CourseFragment();
            case 1:
                return new ProfileFragment();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return tabsize;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }
}
