package com.example.fragmentswithfirebase;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class UserAuth {

    private FirebaseAuth mAuth;
    private static UserAuth instance;

    private UserAuth() {
        mAuth = FirebaseAuth.getInstance();
    }

    public static UserAuth getInstance() {
        if (instance == null) {
            instance = new UserAuth();
        }
        return instance;
    }


    public void login(String email, String password, FragmentActivity executor) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(executor, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(executor, "login success", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(executor, "login failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void register(String email, String password, FragmentActivity executor) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(executor, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(executor, "register success", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(executor, "register failed", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public FirebaseUser getCurrentUser() {
        return mAuth.getCurrentUser();
    }

}
