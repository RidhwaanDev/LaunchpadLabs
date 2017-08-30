package com.ridhwaan.Launchpad.Firebase;

import android.content.Context;

import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Ridhwaan on 8/29/17.
 */

public class FireBaseSession {

    private static FireBaseSession mSession;
    private FireBaseUserModel mUserModel;



    public static FireBaseSession getInstance(Context c){

        if (mSession == null){
            mSession = new FireBaseSession(c);
        }
            return mSession;

    }

    private FireBaseSession (Context c){
        mUserModel = new FireBaseUserModel();

    }

    public FireBaseUserModel getSession(FirebaseUser user){

        mUserModel.setmUserName(user.getDisplayName());
        mUserModel.setmEmail(user.getEmail());
        
        return mUserModel;

    }

   
}
