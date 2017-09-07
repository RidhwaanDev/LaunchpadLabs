package com.ridhwaan.Launchpad.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.ridhwaan.Launchpad.Adapters.ChatAdapter;
import com.ridhwaan.Launchpad.Firebase.FireBaseManager;
import com.ridhwaan.Launchpad.Firebase.FireBaseSession;
import com.ridhwaan.Launchpad.Firebase.FireBaseUserModel;
import com.ridhwaan.Launchpad.model.ChatMessageModel;
import com.ridhwaan.hazratmp3.R;

/**
 * Created by Ridhwaan on 9/7/17.
 */

public class ChatFragment extends Fragment {

    private RecyclerView mChatRecyclerView;
    private ChatAdapter mChatAdapter;
    private EditText mEditMessageText;
    private Button mSendMsgButton;


    public static ChatFragment newInstance(){
        return new ChatFragment();
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chat,container,false);

        final FireBaseManager manager = new FireBaseManager();
        final DatabaseReference ref = manager.getChatRef();

        FireBaseSession session = FireBaseSession.getInstance(getActivity());
        final FireBaseUserModel userModel = session.getSession();
        final String userName = userModel.getmUserName();

        mEditMessageText = (EditText) v.findViewById(R.id.edx_message);
        mSendMsgButton = (Button) v.findViewById(R.id.btn_send);

        mChatAdapter = new ChatAdapter(getActivity(), userModel);

        mSendMsgButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ChatMessageModel msg = new ChatMessageModel();
                msg.setName(userName);
                msg.setContent(mEditMessageText.getEditableText().toString().trim());
                manager.addChatMessage(msg);
                mChatAdapter.addMessage(msg);
                mEditMessageText.getText().clear();
            }
        });


        ref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                ChatMessageModel msg = dataSnapshot.getValue(ChatMessageModel.class);

                if(!(msg.getName() == userModel.getmUserName())){
                    mChatAdapter.addMessage(msg);
                }
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {



            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

                mChatAdapter.clear();



            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mChatRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view_chat);
        mChatRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mChatRecyclerView.setAdapter(mChatAdapter);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }
}
