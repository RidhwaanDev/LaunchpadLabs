package com.ridhwaan.Launchpad.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ridhwaan.Launchpad.Adapters.CourseProfileAdapter;
import com.ridhwaan.Launchpad.model.CourseModel;
import com.ridhwaan.hazratmp3.R;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

/**
 * Created by Ridhwaan on 6/15/17.
 */

public class ProfileFragment extends Fragment {

    private RecyclerView mProfileCourseRecyclerView;
    private CourseProfileAdapter mCourseProfileAdapter;
    private static ArrayList<CourseModel> dataset;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        CourseFragment.registerBus(this);
    }

    public static Fragment newInstance() {

        return new ProfileFragment();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_profile, null , false);

        mProfileCourseRecyclerView = (RecyclerView) v.findViewById(R.id.profile_course_recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        mProfileCourseRecyclerView.setLayoutManager(layoutManager);

        return v;
    }

    @Subscribe public void getData(ArrayList<CourseModel> list)
    {

        dataset = list;


        mCourseProfileAdapter = new CourseProfileAdapter(getActivity(),dataset);
        mProfileCourseRecyclerView.setAdapter(mCourseProfileAdapter);



    }


}


