package com.ridhwaan.Launchpad.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.ridhwaan.Launchpad.Fragment.CourseFragment;
import com.ridhwaan.Launchpad.SingleFragmentActivity;
import com.ridhwaan.hazratmp3.R;

public class CourseDescriptionActivity extends AppCompatActivity {

    private String COURSE_TITLE;
    private TextView mContentTextView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        View v = findViewById(R.id.content_view);
        mContentTextView =  (TextView) v.findViewById(R.id.course_description);
        mContentTextView.setText(R.string.course_programming);


        Intent i = getIntent();
        if(i.getExtras() != null){

            Bundle args = i.getExtras();
            COURSE_TITLE =  (String) args.get(CourseFragment.COURSE_DESCRIPTOR_KEY);

        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(COURSE_TITLE);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
