package com.presidency.resultpro;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivitynew extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Check current user
      FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
      firebaseAuth.addAuthStateListener(authStateListener);
    }
    FirebaseAuth.AuthStateListener authStateListener = new FirebaseAuth.AuthStateListener() {
        @Override
        public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
            FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();

           if (firebaseUser == null) {
                Intent intent = new Intent(MainActivitynew.this, SignUpActivitynew.class);
                startActivity(intent);
                finish();
            }
            if (firebaseUser != null) {
                Intent intent = new Intent(MainActivitynew.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }
    };
}