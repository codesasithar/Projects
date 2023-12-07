package com.presidency.resultpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

public class Subjects extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subjects);
        ImageView image = findViewById(R.id.image);
        String subjects[] ={"SEMESTER I","SEMESTER II","SEMESTER III","SEMESTER IV","SEMESTER V","SEMESTER VI"};
        String myString="1";
        Spinner spinnersub=findViewById(R.id.spinnersubject);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.spinnerlist,subjects);
        spinnersub.setAdapter(adapter);
        int spinnerPosition = adapter.getPosition(myString);
        spinnersub.setSelection(spinnerPosition);

        spinnersub.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        image.setImageResource(R.drawable.sem1);
                        break;
                    case 1:
                        image.setImageResource(R.drawable.sem2);
                        break;
                    case 2:
                        image.setImageResource(R.drawable.sem3);
                        break;
                    case 3:
                        image.setImageResource(R.drawable.sem4);
                        break;
                    case 4:
                        image.setImageResource(R.drawable.sem5);
                        break;
                    case 5:
                        image.setImageResource(R.drawable.sem6);
                        break;
                    default:
                        //Default image
                        //image.setImageResource(R.drawable.item2);
                        break;

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });









    }
}