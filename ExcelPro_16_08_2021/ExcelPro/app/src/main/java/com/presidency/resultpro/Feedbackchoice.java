package com.presidency.resultpro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Feedbackchoice extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedbackchoice);
        CardView teach=findViewById(R.id.cgg1);
        CardView studentfeedback=findViewById(R.id.cgg2);
        teach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Feedbackchoice.this,Feedbackteachview.class);
                startActivity(intent);
            }
        });




        studentfeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Feedbackchoice.this,FeedbackView.class);
                startActivity(intent);
            }
        });


    }
}