package com.ridhwaan.Launchpad.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;
import com.ridhwaan.Launchpad.Activities.CourseDescriptionActivity;
import com.ridhwaan.Launchpad.Adapters.CourseGridAdapter;
import com.ridhwaan.Launchpad.Firebase.FireBaseManager;
import com.ridhwaan.Launchpad.model.CourseModel;
import com.ridhwaan.hazratmp3.R;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;
import com.squareup.otto.ThreadEnforcer;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Ridhwaan on 3/4/2017.
 */

public class CourseFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private CourseGridAdapter courseGridAdapter;
    private ArrayList<CourseModel> list;
    private Boolean isComplete;
    private int count = 0;
    private int datacnt;

    private static Bus bus;
    public static Bus profileBus;

    public static final String COURSE_DESCRIPTOR_KEY = "1001";
    public static final String CONTEXT = "1002";


    public static CourseFragment newInstance() {
        return new CourseFragment();
    }

    public static void registerBus(Object o ){
        profileBus.register(o);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bus = new Bus(ThreadEnforcer.MAIN);
        profileBus = new Bus(ThreadEnforcer.MAIN);
        bus.register(this);
        list = new ArrayList<>();

        FireBaseManager fireBaseManager = new FireBaseManager();
        DatabaseReference ref = fireBaseManager.getCourseRef();

         ref.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
                datacnt = (int) dataSnapshot.getChildrenCount();
            isComplete = new Boolean(false);

                Iterable<DataSnapshot> itr = dataSnapshot.getChildren();
                for(DataSnapshot data: itr){
                    count++;
                    if( count >= datacnt){
                        isComplete = true;
                        bus.post(isComplete);
                    } else {


                            CourseModel c = data.getValue(CourseModel.class);
                            Log.d("Iter test", "    " + c.getmCourseTitle());
                            bus.post(c);

                    }
                }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });

    }

    @Subscribe public void onCourseRecieved(CourseModel c){
        list.add(c);
    }

    @Subscribe public void onDownloadComplete(Boolean e){

        Log.d("Iter test", "    " + e.toString() +  "   " + list.size());

        profileBus.post(list);

        if(e.booleanValue()){
            courseGridAdapter = new CourseGridAdapter(getActivity(), list);
            courseGridAdapter.notifyDataSetChanged();
            mRecyclerView.setAdapter(courseGridAdapter);


            // TODO: 9/5/17 Change FireBaseManager to singelton ASAP

            courseGridAdapter.setOnCourseClickListener(new CourseGridAdapter.OnCourseclickListener() {
                @Override
                public void onCourseClicked(CourseModel course) {
                    Intent i = new Intent(getActivity(), CourseDescriptionActivity.class);
                    Bundle args = new Bundle();
                    args.putSerializable(COURSE_DESCRIPTOR_KEY, course);
                    i.putExtras(args);
                    getActivity().startActivity(i);
                }
            });
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_manager, container, false);

        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_player);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }

    // TODO: update list

}
