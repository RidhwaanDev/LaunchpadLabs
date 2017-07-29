package com.ridhwaan.Launchpad.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ridhwaan.hazratmp3.R;

/**
 * Created by Ridhwaan on 3/19/2017.
 */

public class CourseGridAdapter extends RecyclerView.Adapter<CourseHolder> {

    private Context mContext;
    public static  String[] dataSet;
    public static OnCourseclickListener mClickListener;


    public interface OnCourseclickListener{

        void onCourseClicked(String course);
    }

    public void setOnCourseClickListener(OnCourseclickListener listener){

        mClickListener = listener;

    }


    public CourseGridAdapter(Context context, String[] dataSet){

        this.mContext = context;
        this.dataSet = dataSet;
    }

    @Override
    public CourseHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.course_item,parent,false);
        return new CourseHolder(v,mContext);



    }

    @Override
    public void onBindViewHolder(CourseHolder holder, int position) {
        String course = dataSet[position];
        holder.bindHolder(course,position);

    }


    @Override
    public int getItemCount() {
        return dataSet.length;
    }



}

   class CourseHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

       private int position;
       private String course;
       private TextView mTitleView;
       private TextView mContentView;
       private Context c = null;

    public CourseHolder(View itemView, Context c ) {
        super(itemView);
        mTitleView = (TextView) itemView.findViewById(R.id.course_title);
        mContentView = (TextView) itemView.findViewById(R.id.course_content);
        itemView.setOnClickListener(this);
        this.c = c;

    }

    @Override
    public void onClick(View view) {
        //// TODO: 3/19/2017 update player manager
        Log.d("TAG", "ITEM CLICK");
        CourseGridAdapter.mClickListener. onCourseClicked(course);

    }


    public void bindHolder(String courseName, int position){
        mTitleView.setText(courseName);
        this.position = position;
        this.course = CourseGridAdapter.dataSet[position];
    }


}