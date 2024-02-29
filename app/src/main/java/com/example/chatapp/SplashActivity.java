package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {
    private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        auth=FirebaseAuth.getInstance();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                FirebaseUser currentUser=auth.getCurrentUser();
                if(currentUser!=null){
                    startActivity(new Intent(SplashActivity.this,MainActivity.class));
                }
                else{
                    startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                    finish();
                }

            }
        },2000);
    }
}