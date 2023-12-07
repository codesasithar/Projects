package com.presidency.resultpro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class notificationchoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificationchoice);
        CardView teach=findViewById(R.id.cgg1);
        CardView studentfeedback=findViewById(R.id.cgg2);
        teach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(notificationchoice.this,teachernotifications.class);
                startActivity(intent);
            }
        });




        studentfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(notificationchoice.this,Notifications.class);
                startActivity(intent);
            }
        });


    }
}