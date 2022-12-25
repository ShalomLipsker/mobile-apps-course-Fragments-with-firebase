package com.example.fragmentswithfirebase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import java.util.concurrent.Executor;


public class LoginFormScreen extends Fragment {

    private View view;

    public LoginFormScreen() {
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
        view = inflater.inflate(R.layout.fragment_login_form_screen, container, false);

        Button loginBtn = view.findViewById(R.id.LoginBtn);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();
            }
        });

        return view;
    }

    public void login() {

        EditText emailField = view.findViewById(R.id.editTextTextEmailAddressLogin);
        EditText passwordField = view.findViewById(R.id.editTextNumberPasswordLogin);

        UserAuth userAuth = UserAuth.getInstance();

        userAuth.login(emailField.getText().toString(), passwordField.getText().toString(), getActivity());
        Navigation.findNavController(view).navigate(R.id.action_loginFormScreen_to_welcomeScreen);
    }
}