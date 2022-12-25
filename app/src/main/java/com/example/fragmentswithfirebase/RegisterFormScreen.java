package com.example.fragmentswithfirebase;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class RegisterFormScreen extends Fragment {

    private View view;

    public RegisterFormScreen() {
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
        view = inflater.inflate(R.layout.fragment_register_form_screen, container, false);

        Button registerBtn = view.findViewById(R.id.RegisterBtn);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });

        return view;
    }

    public void register() {
        EditText emailField = view.findViewById(R.id.editTextTextEmailAddressRegister);
        EditText passwordField = view.findViewById(R.id.editTextNumberPasswordRegister);
        EditText addressField = view.findViewById(R.id.editTextAddress);
        EditText phoneField = view.findViewById(R.id.editTextPhone);

        String email = emailField.getText().toString();
        String password = passwordField.getText().toString();
        String address = addressField.getText().toString();
        String phone = phoneField.getText().toString();

        if (email == "" || password == "" || address == "" || phone == "") {
            Toast.makeText(getActivity(), "one or more filed are empty", Toast.LENGTH_LONG).show();
        } else {
            UserAuth userAuth = UserAuth.getInstance();

            userAuth.register(email, password, getActivity());
            userAuth.login(email, password, getActivity());
            String userId = userAuth.getCurrentUser().getUid();

            UserInfo userInfo = new UserInfo(email, userId, phone, address);

            DbClient dbClient = DbClient.getInstance();
            dbClient.createUser(userId, userInfo);

            Navigation.findNavController(view).navigate(R.id.action_registerFormScreen_to_welcomeScreen);
        }
    }
}