package com.ridhwaan.Launchpad.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ridhwaan.Launchpad.Adapters.CourseGridAdapter;
import com.ridhwaan.Launchpad.CourseManager.CourseManager;
import com.ridhwaan.hazratmp3.R;

/**
 * Created by Ridhwaan on 3/4/2017.
 */

public class CourseFragment extends Fragment implements ActivityCompat.OnRequestPermissionsResultCallback {





    private RecyclerView mRecyclerView;
    private CourseGridAdapter courseGridAdapter;



    public static CourseFragment newInstance() {

        return new CourseFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //check for permission



    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_player, container, false);


        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_player);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));


        courseGridAdapter = new CourseGridAdapter(getActivity(), CourseManager.courses);
        courseGridAdapter.setOnCourseClickListener(new CourseGridAdapter.OnCourseclickListener() {
            @Override
            public void onCourseClicked(String course) {

                Toast.makeText(getActivity(),course,Toast.LENGTH_SHORT).show();

            }
        });
        mRecyclerView.setAdapter(courseGridAdapter);


        return v;
    }



}
