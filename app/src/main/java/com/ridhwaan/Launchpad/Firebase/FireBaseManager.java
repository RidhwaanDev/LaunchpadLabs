package com.ridhwaan.Launchpad.Firebase;

import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Ridhwaan on 7/29/17.
 */

public class FireBaseManager {



    public static FirebaseDatabase getDataBase(){
        FirebaseDatabase  fbdb = FirebaseDatabase.getInstance();
        return  fbdb;
    }


    public DatabaseReference createRef(String key){

        DatabaseReference ref = getDataBase().getReference().child(key);
        return ref;

    }

    public void addEntry(DatabaseReference reference, String value){
        reference.push().setValue(value);

    }

    public void addModelEntry(DatabaseReference reference, Object obj){
        reference.push().setValue(obj);
    }

    public void addUser( FireBaseUserModel user){

        DatabaseReference ref = getDataBase().getReference().child("Users");
        addModelEntry(ref, user);


    }



}
