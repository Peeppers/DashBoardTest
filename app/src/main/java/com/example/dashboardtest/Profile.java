package com.example.dashboardtest;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Profile extends AppCompatActivity {

    private FirebaseAuth mAuth;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile);

        mAuth=FirebaseAuth.getInstance();

        FirebaseUser user = mAuth.getCurrentUser();

        String email = user.getEmail();
    }
}