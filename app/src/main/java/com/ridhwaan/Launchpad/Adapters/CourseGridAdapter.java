package com.ridhwaan.Launchpad.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.ridhwaan.Launchpad.Fragment.CourseFragment;
import com.ridhwaan.Launchpad.model.CourseModel;
import com.ridhwaan.hazratmp3.R;

import java.util.ArrayList;

/**
 * Created by Ridhwaan on 3/19/2017.
 */

public class CourseGridAdapter extends RecyclerView.Adapter<CourseHolder> {

    private Context mContext;
    public static ArrayList<CourseModel> mDataSet;
    public static OnCourseclickListener mClickListener;


    public interface OnCourseclickListener{

        void onCourseClicked(CourseModel courseModel);
    }

    public void setOnCourseClickListener(OnCourseclickListener listener){
        mClickListener = listener;
    }

    public CourseGridAdapter(Context context,  ArrayList<CourseModel> listOfItems){
        this.mContext = context;
        this.mDataSet = listOfItems ;
    }

    @Override
    public CourseHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View v = inflater.inflate(R.layout.course_item,parent,false);
        return new CourseHolder(v,mContext);
    }

    @Override
    public void onBindViewHolder(CourseHolder holder, int position) {
        CourseModel courseModel = mDataSet.get(position);
        holder.bindHolder(courseModel,position);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

}
   class CourseHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

       private int position;
       private CourseModel course;
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
        CourseGridAdapter.mClickListener.onCourseClicked(course);
    }

    public void bindHolder(CourseModel courseModel, int position){
        mTitleView.setText(courseModel.getmCourseTitle());
        this.position = position;
        this.course = CourseGridAdapter.mDataSet.get(position);
    }
}