package com.presidency.resultpro;



import androidx.cardview.widget.CardView;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;

public class choosedept extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosedept);

        CardView credup=findViewById(R.id.credbtn);
        CardView bca = findViewById(R.id.c2);
        bca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choosedept.this, ExcelUpload.class);
                startActivity(intent);
            }
        });

        credup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choosedept.this, uploadcred.class);
                startActivity(intent);
            }
        });

    }
}
