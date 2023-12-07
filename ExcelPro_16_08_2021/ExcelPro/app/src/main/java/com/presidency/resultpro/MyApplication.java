package com.presidency.resultpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.firebase.client.Firebase;

public class MyApplication extends android.app.Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}