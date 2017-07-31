package com.ridhwaan.Launchpad.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.ridhwaan.hazratmp3.R;

/**
 * Created by Ridhwaan on 6/15/17.
 */

public class ProfileFragment extends Fragment {

    private FirebaseAuth mFireBaseAuth;
    private FirebaseAuth.AuthStateListener mAuthStateListener;

    private Button mAddAcntBtn;



    private static final int RC_AUTH_FLOW = 1001;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public static Fragment newInstance() {

        return new ProfileFragment();
    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_login,container,false);

        mFireBaseAuth = FirebaseAuth.getInstance();


        mAddAcntBtn = (Button) v.findViewById(R.id.add_account_btn);



                mAuthStateListener = new FirebaseAuth.AuthStateListener() {
                    @Override
                    public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {


                        FirebaseUser user = firebaseAuth.getCurrentUser();
                        if(user != null){

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







        return v;
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


