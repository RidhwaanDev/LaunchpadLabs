package com.ridhwaan.Launchpad;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.ridhwaan.hazratmp3.R;

/**
 * Created by Ridhwaan on 3/4/2017.
 */

public abstract class SingleFragmentActivity extends AppCompatActivity {



    public abstract Fragment createFragment();


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_layout_generic);


        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_layout_id);

        if(fragment == null){
            fragment = createFragment();

            fragmentManager.beginTransaction().add(R.id.fragment_layout_id,fragment).commit();
        }

    }


}


