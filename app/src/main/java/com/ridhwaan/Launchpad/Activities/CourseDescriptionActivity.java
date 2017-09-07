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
import android.widget.Toast;

import com.ridhwaan.Launchpad.Firebase.FireBaseManager;
import com.ridhwaan.Launchpad.Firebase.FireBaseSession;
import com.ridhwaan.Launchpad.Firebase.FireBaseUserModel;
import com.ridhwaan.Launchpad.Fragment.CourseFragment;
import com.ridhwaan.Launchpad.SingleFragmentActivity;
import com.ridhwaan.Launchpad.model.CourseModel;
import com.ridhwaan.hazratmp3.R;

import java.util.HashMap;
import java.util.Objects;

public class CourseDescriptionActivity extends AppCompatActivity {

    private CourseModel course;
    private TextView mContentTextView;
    private String mCourseTitle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);

        View v = findViewById(R.id.content_view);
        mContentTextView =  (TextView) v.findViewById(R.id.course_content);


        Intent i = getIntent();
        if(i.getExtras() != null){

            Bundle args = i.getExtras();
            course =  (CourseModel) args.getSerializable(CourseFragment.COURSE_DESCRIPTOR_KEY);
            mCourseTitle = course.getmCourseTitle();

        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(course.getmCourseTitle());
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final FireBaseSession session = FireBaseSession.getInstance(CourseDescriptionActivity.this);
                FireBaseUserModel userModel = session.getSession();

                CourseModel courseModel = new CourseModel();
                courseModel.setmCourseContent("Programming is very fun oh my god");
                courseModel.setmCourseInstructorEmail("uthman@gmail.com");
                courseModel.setmCourseInstructorName("Uthy the Puthy");
                courseModel.setmCourseTitle("Programming 101 w/ C#");

                userModel.addCourse("Programming", courseModel);

                HashMap<String,Object> updatedCourseMap = new HashMap<>();
                updatedCourseMap.put( mCourseTitle, courseModel);

                FireBaseManager manager = session.getmFireBaseManager();
                manager.updateUserCourseList(userModel.getmID().toString(),"mCourseList", updatedCourseMap);

                Toast.makeText(CourseDescriptionActivity.this, course.getmCourseTitle() + " " + "has been added to your course list", Toast.LENGTH_SHORT)
                        .show();


            }
        });
    }
}
