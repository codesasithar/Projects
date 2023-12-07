package com.presidency.resultpro;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;


import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class teachernotifications extends Activity {
    DatabaseReference rootRef, demoRef;
    private ArrayList<String> Userlist;

    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teachernotifications);
        TextView fetchedtext = findViewById(R.id.fetchedText);
        rootRef = FirebaseDatabase.getInstance().getReference();

        // Database reference pointing to demo node
        demoRef = rootRef.child("ExcelPro").child("FacultyNotifications");
        demoRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Userlist = new ArrayList<String>();
                for (DataSnapshot dsp : dataSnapshot.getChildren()) {
                    Userlist.add(String.valueOf(dsp.getValue())); //add result into array list


                    String output = "";

                    for (int i = 0; i < Userlist.size(); i++) {
                        //Append all the values to a string
                        output += ("\u2022")+Userlist.get(i)+("\n\n");
                    }

                    //Set the textview to the output string
                    fetchedtext.setText(output);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}