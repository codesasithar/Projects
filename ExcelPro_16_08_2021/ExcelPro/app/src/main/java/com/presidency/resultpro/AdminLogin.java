package com.presidency.resultpro;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class AdminLogin extends Activity {
    Button b1,b2;
    EditText ed1,ed2;
    ImageView img;

    TextView tx1,attempt;
    int counter = 3;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        b1 = findViewById(R.id.button25);
        ed1 = findViewById(R.id.editText25);
        ed2 = findViewById(R.id.editText27);
        attempt=findViewById(R.id.attempt);
        img=findViewById(R.id.img);
        tx1 = findViewById(R.id.textView11);
        tx1.setVisibility(View.GONE);
        attempt.setVisibility(View.GONE);

        b1.setOnClickListener(v -> {
            if(ed1.getText().toString().equals("admin") &&
                    ed2.getText().toString().equals("admin")) {
                Toast.makeText(getApplicationContext(),
                        "Welcome Admin !",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AdminLogin.this,AdminDashboard.class);
                startActivity(intent);
            }else{
                Toast.makeText(getApplicationContext(), "Wrong Credentials",Toast.LENGTH_SHORT).show();
                attempt.setVisibility(View.VISIBLE);
                tx1.setVisibility(View.VISIBLE);
                tx1.setBackgroundColor(Color.BLUE);
                counter--;
                tx1.setText(Integer.toString(counter));

                if (counter == 0) {
                    b1.setEnabled(false);
                }
            }
        });



    }
}