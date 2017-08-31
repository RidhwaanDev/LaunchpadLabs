package com.ridhwaan.Launchpad.Firebase;

import android.content.Context;

import com.google.firebase.auth.FirebaseUser;
import com.ridhwaan.Launchpad.model.CourseModel;

/**
 * Created by Ridhwaan on 8/29/17.
 */

public class FireBaseSession {

    private static FireBaseSession mSession;
    private FireBaseUserModel mCurrentUser;
    private static FireBaseManager mFireBaseManager;


    //test



    public static FireBaseSession getInstance(Context c){

        if (mSession == null){
            mSession = new FireBaseSession(c);
        }
            return mSession;

    }

    private FireBaseSession (Context c){
         mCurrentUser = new FireBaseUserModel();
        mFireBaseManager = new FireBaseManager();

    }

    public void setSession(FirebaseUser user){

         mCurrentUser.setmUserName(user.getDisplayName());
         mCurrentUser.setmEmail(user.getEmail());

    }

    public FireBaseUserModel getSession(){

        return  mCurrentUser;

    }

    public FireBaseManager getmFireBaseManager (){
        return mFireBaseManager;
    }

   
}
