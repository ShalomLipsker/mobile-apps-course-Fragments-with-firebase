package com.example.fragmentswithfirebase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class EntryScreen extends Fragment {

    public EntryScreen() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_entry_screen, container, false);

        final View.OnClickListener mListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavController navController = Navigation.findNavController(view);
                switch (view.getId()) {
                    case R.id.loginScreenBtn:
                        navController.navigate(R.id.action_entryScreen_to_loginFormScreen);
                        break;
                    case R.id.RegisterScreenBtn:
                        navController.navigate(R.id.action_entryScreen_to_registerFormScreen5);
                        break;
                }
            }
        };

        Button loginBtn = view.findViewById(R.id.loginScreenBtn);
        loginBtn.setOnClickListener(mListener);

        Button registerBtn = view.findViewById(R.id.RegisterScreenBtn);
        registerBtn.setOnClickListener(mListener);

        return view;
    }
}