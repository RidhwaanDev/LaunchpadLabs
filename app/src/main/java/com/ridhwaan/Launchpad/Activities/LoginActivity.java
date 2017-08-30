package com.ridhwaan.Launchpad.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.ridhwaan.Launchpad.Firebase.FireBaseInit;
import com.ridhwaan.Launchpad.Firebase.FireBaseManager;
import com.ridhwaan.Launchpad.Firebase.FireBaseSession;
import com.ridhwaan.Launchpad.Firebase.FireBaseUserModel;

/**
 * Created by Ridhwaan on 7/30/17.
 */

public class LoginActivity extends AppCompatActivity {

    private FirebaseAuth mFireBaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;
    private static final int RC_AUTH_FLOW = 1001;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFireBaseAuth = FirebaseAuth.getInstance();

        mAuthStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {


                FirebaseUser user = firebaseAuth.getCurrentUser();
                if(user != null){

                    FireBaseInit.init();

                    FireBaseSession session = FireBaseSession.getInstance(LoginActivity.this);
                    FireBaseUserModel userModel = session.getSession(user);

                    FireBaseManager manager = new FireBaseManager();
                    manager.addUser(userModel);

                    Intent intent = new Intent(LoginActivity.this, EntryPoint.class);
                    startActivity(intent);

                    //login flow
                } else{
                    //sign in flow
                    startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
                            .setProviders(AuthUI.EMAIL_PROVIDER,AuthUI.GOOGLE_PROVIDER)
                            .setIsSmartLockEnabled(false)
                            .build(),RC_AUTH_FLOW);

                }
            }
        };


    }


    @Override
    public void onResume() {
        super.onResume();
        mFireBaseAuth.addAuthStateListener(mAuthStateListener);
    }


    @Override
    public void onPause() {
        super.onPause();
        mFireBaseAuth.removeAuthStateListener(mAuthStateListener);
    }


}
