package com.presidency.resultpro;

import androidx.cardview.widget.CardView;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
public class welcome extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);


        CardView c1 = findViewById(R.id.c1);
        c1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(welcome.this,AdminLogin.class);
                startActivity(intent);
            }
        });
        CardView c2 = findViewById(R.id.c2);
        c2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(welcome.this,FacultyLoginActivity.class);
                startActivity(intent);
            }
        });
        CardView c3 = findViewById(R.id.c3);
        c3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(welcome.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        CardView c4 = findViewById(R.id.c4);
        c4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pid = android.os.Process.myPid();
           finishActivity(0);
           finishAndRemoveTask();
           finishAffinity();
           System.exit(0);

            }
        });


    }
    public void onBackPressed() {
    // super.onBackPressed();
    // Not calling **super**, disables back button in current screen.
        Toast.makeText(getApplicationContext(),"Please Choose an option!",Toast.LENGTH_SHORT).show();
    }
}
