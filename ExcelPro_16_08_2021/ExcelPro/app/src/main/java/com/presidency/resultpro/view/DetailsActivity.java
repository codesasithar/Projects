package com.presidency.resultpro.view;

import android.content.Intent;
import android.os.Bundle;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.presidency.resultpro.R;
import com.squareup.picasso.Picasso;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;


public class DetailsActivity extends AppCompatActivity {

    TextView nameDetailTextView,descriptionDetailTextView,dateDetailTextView,categoryDetailTextView;
    ImageView teacherDetailImageView;

    private void initializeWidgets(){
        nameDetailTextView= findViewById(R.id.nameDetailTextView);
        descriptionDetailTextView= findViewById(R.id.descriptionDetailTextView);
        dateDetailTextView= findViewById(R.id.dateDetailTextView);
       /// categoryDetailTextView= findViewById(R.id.categoryDetailTextView);
        teacherDetailImageView=findViewById(R.id.teacherDetailImageView);
    }
    private String getDateToday(){
        DateFormat dateFormat=new SimpleDateFormat("dd/mm/yyyy");
        Date date=new Date();
        String today= dateFormat.format(date);
        return today;
    }
    private String getRandomCategory(){
        String[] categories={"BCA A","BCA B","BCA C"};
        Random random=new Random();
        int index=random.nextInt(categories.length-1);
        return categories[index];
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initializeWidgets();

        //RECEIVE DATA FROM ITEMSA2CTIVITY VIA INTENT
        Intent i=this.getIntent();
        String registernumber=i.getExtras().getString("registernumber");
        String password=i.getExtras().getString("password");
        String imageURL=i.getExtras().getString("IMAGE_KEY");

        //SET RECEIVED DATA TO TEXTVIEWS AND IMAGEVIEWS
        nameDetailTextView.setText(registernumber);
        descriptionDetailTextView.setText(password);
        dateDetailTextView.setText("DATE: "+getDateToday());
        //categoryDetailTextView.setText("CATEGORY: "+getRandomCategory());
        Picasso.get()
                .load(imageURL)
                .placeholder(R.drawable.placeholder)
                .fit()
                .centerCrop()
                .into(teacherDetailImageView);

    }

}
