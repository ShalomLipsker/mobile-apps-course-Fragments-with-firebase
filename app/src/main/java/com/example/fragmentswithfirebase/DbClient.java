package com.example.fragmentswithfirebase;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class DbClient {

    private static DbClient instance;

    private DbClient() {
        this.database = FirebaseDatabase.getInstance();
    }

    public static DbClient getInstance() {
        if (instance == null) {
            instance = new DbClient();
        }
        return instance;
    }

    FirebaseDatabase database;
    private final String USERS_COLLECTION_ID = "users";

    public void createUser(String id, UserInfo userInfo) {
        DatabaseReference myRef = database.getReference(USERS_COLLECTION_ID).child(id);
        myRef.setValue(userInfo);
    }

    public UserInfo getUser(String id) {
        DatabaseReference myRef = database.getReference(USERS_COLLECTION_ID).child(id);
        final UserInfo[] value = new UserInfo[1];

        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                value[0] = dataSnapshot.getValue(UserInfo.class);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
            }
        });

        return value[0];
    };
}
