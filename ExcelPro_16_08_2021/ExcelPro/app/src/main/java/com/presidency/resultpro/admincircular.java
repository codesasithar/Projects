package com.presidency.resultpro;


import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.text.SimpleDateFormat;
import java.util.Date;


public class admincircular extends AppCompatActivity {

    EditText editText1;
    Button submit;
    DatabaseReference rootRef, demoRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admincircular);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yy HH:mm:ss-aa ");
        String currentDateandTime = sdf.format(new Date());
        submit=findViewById(R.id.btnSubmit);
        editText1=findViewById(R.id.etValue);
        // Database reference pointing to root of database
        rootRef = FirebaseDatabase.getInstance().getReference();
        // Database reference pointing to demo node
        demoRef = rootRef.child("ExcelPro").child("notifications").child(currentDateandTime);
        submit.setOnClickListener(v -> { String value = currentDateandTime+"-"+editText1.getText().toString();
        // Push creates a unique id in database
            demoRef.setValue(value);
            Toast.makeText(getApplicationContext(),"Circular published !",Toast.LENGTH_SHORT).show();
        });

    }

}





