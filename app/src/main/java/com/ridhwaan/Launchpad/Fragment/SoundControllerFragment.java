package com.ridhwaan.Launchpad.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ridhwaan.hazratmp3.R;

/**
 * Created by Ridhwaan on 3/19/2017.
 */

public class SoundControllerFragment extends Fragment {



    private Button mPlayButton;
    private Button mPauseButton;

    public static SoundControllerFragment newInstance(){
        return new SoundControllerFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
                View v = inflater.inflate(R.layout.fragment_detailcourse_layout,container,false);



        return v;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
