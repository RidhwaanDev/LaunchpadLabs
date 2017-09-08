package com.ridhwaan.Launchpad.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ridhwaan.Launchpad.model.CourseModel;
import com.ridhwaan.hazratmp3.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by Ridhwaan on 9/6/17.
 */

public class CourseProfileAdapter extends RecyclerView.Adapter<CourseProfileHolder> {

    private Context context;
    public static ArrayList<CourseModel> mCourseList;

    public CourseProfileAdapter (Context c , ArrayList<CourseModel> dataset){
        this.context = c ;
        this.mCourseList = dataset;
    }


    @Override
    public CourseProfileHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.course_item,parent,false);
        return new CourseProfileHolder(v,context);
    }

    @Override
    public void onBindViewHolder(CourseProfileHolder holder, int position) {
        CourseModel c  = mCourseList.get(position);
        holder.bindHolder(c,position);
    }

    @Override
    public int getItemCount() {
        return mCourseList.size();
    }


}
class CourseProfileHolder extends RecyclerView.ViewHolder{

    private TextView mTitleOfCourse;
    private TextView mContentTextView;
    private CourseModel mCourseModel;
    private int position;

    public CourseProfileHolder(View itemView, Context c ) {
        super(itemView);
        mTitleOfCourse = (TextView) itemView.findViewById(R.id.course_title);
        mContentTextView = (TextView) itemView.findViewById(R.id.course_content);
    }


    public void bindHolder(CourseModel courseModel, int position){
        mTitleOfCourse.setText(courseModel.getmCourseTitle());
        mContentTextView.setText(courseModel.getmCourseContent());
        this.position = position;
        this.mCourseModel = CourseProfileAdapter.mCourseList.get(position);
    }

}
