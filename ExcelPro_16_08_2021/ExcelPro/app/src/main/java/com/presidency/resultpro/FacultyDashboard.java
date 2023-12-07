package com.presidency.resultpro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FacultyDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty_dashboard);

        CardView marklist,cardfeed,cardnotify,cggraph,subcard2,events;
        marklist=findViewById(R.id.cdmarks);
        cardfeed=findViewById(R.id.cardfeed);
        cardnotify=findViewById(R.id.cardnotify);
        events=findViewById(R.id.attendancecardfaculty);
        cggraph=findViewById(R.id.cggraph);
        subcard2=findViewById(R.id.subcardupload);


        marklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacultyDashboard.this,choosedept.class);
                startActivity(intent);
            }
        });

        cardfeed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacultyDashboard.this,FeedbackTeachers.class);
                startActivity(intent);
            }
        });

        cardnotify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacultyDashboard.this,teachercircular.class);
                startActivity(intent);
            }
        });

        cggraph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacultyDashboard.this,changepwdfaculty.class);
                startActivity(intent);
            }
        });
        subcard2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacultyDashboard.this,resultcard.class);
                startActivity(intent);
            }
        });
        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FacultyDashboard.this,UploadEvents.class);
                startActivity(intent);
            }
        });




    }
}