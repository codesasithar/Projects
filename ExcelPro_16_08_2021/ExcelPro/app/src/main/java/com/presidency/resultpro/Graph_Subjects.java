package com.presidency.resultpro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Graph_Subjects extends AppCompatActivity {
Button viewg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_subjects_intro);

        viewg=findViewById(R.id.viewg);
        viewg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Graph_Subjects.this,graph.class);
                startActivity(intent);
            }
        });

    }
}