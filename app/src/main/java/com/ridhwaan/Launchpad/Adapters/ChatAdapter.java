package com.ridhwaan.Launchpad.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ridhwaan.Launchpad.Firebase.FireBaseSession;
import com.ridhwaan.Launchpad.Firebase.FireBaseUserModel;
import com.ridhwaan.Launchpad.model.ChatMessageModel;
import com.ridhwaan.Launchpad.model.CourseModel;
import com.ridhwaan.hazratmp3.R;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Ridhwaan on 9/7/17.
 */

public class ChatAdapter extends RecyclerView.Adapter<ChatHolder>{


    private Context context;
    public static ArrayList<ChatMessageModel> mMessageList;
    FireBaseUserModel userModel;

    public ChatAdapter (Context c , FireBaseUserModel user){
        this.context = c ;
        mMessageList = new ArrayList<>();
        this.userModel = user;

    }
    public void addMessage(ChatMessageModel msg){
        mMessageList.add(msg);
        notifyDataSetChanged();

    }

    public void clear(){
        mMessageList.clear();
        notifyDataSetChanged();
    }
    @Override
    public ChatHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.chat_item,parent,false);
        return new ChatHolder(v);
    }

    @Override
    public void onBindViewHolder(ChatHolder holder, int position) {
        ChatMessageModel msg = mMessageList.get(position);
        holder.bindView(msg,userModel);
    }

    @Override
    public int getItemCount() {
        return mMessageList.size();
    }

}

class ChatHolder extends RecyclerView.ViewHolder {

    private ChatMessageModel msg;
    private FireBaseUserModel user;
    private TextView mUserNameTextView;
    private TextView mMessageTextView;

    public ChatHolder(View itemView) {
        super(itemView);
        mUserNameTextView = (TextView) itemView.findViewById(R.id.tv_chat_name_id);
        mMessageTextView = (TextView) itemView.findViewById(R.id.tv_chat_message);

        int[] colors = {Color.RED,Color.YELLOW,Color.BLACK,Color.BLACK,Color.CYAN};
        Random rand = new Random();
        mUserNameTextView.setTextColor(colors[rand.nextInt(5)]);

    }

    public void bindView(ChatMessageModel msg,FireBaseUserModel user){
        this.msg = msg;
        this.user = user;
        mUserNameTextView.setText(msg.getName());
        mMessageTextView.setText(msg.getContent());


    }
}
