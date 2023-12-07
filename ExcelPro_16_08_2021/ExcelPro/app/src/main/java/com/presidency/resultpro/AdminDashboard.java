package com.presidency.resultpro;


import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AdminDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);
        CardView cg2=findViewById(R.id.c2);
        CardView cg1 = findViewById(R.id.cg1);
        CardView cg3 = findViewById(R.id.cdfeed);
        cg2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(AdminDashboard.this, com.presidency.resultpro.view.studentlistview.class);
                startActivity(intent3);
            }
        });

        cg1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboard.this, admincircular.class);
                startActivity(intent);
            }
        });


        cg3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminDashboard.this, Feedbackchoice.class);
                startActivity(intent);
            }
        });

    }
}