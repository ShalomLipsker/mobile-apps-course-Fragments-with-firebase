package com.example.fragmentswithfirebase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

public class WelcomeScreen extends Fragment {

    private View view;


    public WelcomeScreen() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_welcome_screen, container, false);

        Button loginBtn = view.findViewById(R.id.SearchButton);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                search();
            }
        });

        return view;
    }

    public void search() {
        EditText searchField = view.findViewById(R.id.editTextSearch);
        TextView searchResultView = view.findViewById(R.id.textViewSearchResult);
        String searchText = searchField.getText().toString();

        DbClient dbClient = DbClient.getInstance();

        dbClient.findUserByEmail(searchText).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                if (dataSnapshot.getValue() == null) {
                    searchResultView.setText("no result found");
                }
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    UserInfo userInfo = postSnapshot.getValue(UserInfo.class);
                    searchResultView.setText(userInfo.toString());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }
}