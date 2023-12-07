package com.presidency.resultpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class changepwd extends AppCompatActivity {
    DatabaseReference cnsverify2;
    EditText newpwd;
    TextView regno;
    Button confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_changepwd);
        regno=findViewById(R.id.regno);
        newpwd=findViewById(R.id.newpwd);
        confirm=findViewById(R.id.button2);
        String newpwds=newpwd.getText().toString();

        regno.setText(LoginActivity.username);
        String regnos=LoginActivity.username;
        cnsverify2= FirebaseDatabase.getInstance().getReference().child("credentials").child(regnos).child("password");
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newpwds=newpwd.getText().toString();
                if (newpwd.length() < 6) {
                    newpwd.setError(getString(R.string.minimum_password));
                } else {



                cnsverify2.setValue(newpwds);
                Toast.makeText(getApplicationContext(),"Password updated successfully",Toast.LENGTH_LONG).show();
            }
        }
        });
    }
}