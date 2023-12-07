package com.presidency.resultpro.view;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import com.presidency.resultpro.R;


public class studentlistview extends AppCompatActivity {
    private CardView addstudents, viewstudents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.studentss );

        addstudents = findViewById ( R.id.addstudents);
        viewstudents = findViewById ( R.id.viewstudents);

        addstudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(studentlistview.this, viewallstudents.class);
                startActivity(i);
            }
        });
        viewstudents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(studentlistview.this, AddStudents.class);
                startActivity(i);
            }
        });

    }


}
