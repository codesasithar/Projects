package com.presidency.resultpro.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.presidency.resultpro.LoginActivity;
import com.presidency.resultpro.menudrawer;
import com.presidency.resultpro.R;

import spencerstudios.com.bungeelib.Bungee;

public class resultfaculty extends Fragment {

    View view;
    CardView firstButton;
    CardView internalbutton;
    CardView notifybtn,attendancecard,papercard,subcard;
    public ImageView propicbig,logopic;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_resultfaculty, container, false);
// get the reference of Button
        ImageView menuburger=view.findViewById(R.id.menuburger);
        firstButton =  view.findViewById(R.id.cggraph);
        internalbutton = view.findViewById(R.id.cdmarks);
        notifybtn=view.findViewById(R.id.cardnotify);
        propicbig=view.findViewById(R.id.imageView7);
        papercard=view.findViewById(R.id.cardfeed);
        subcard=view.findViewById(R.id.attendancecard);
        logopic=view.findViewById(R.id.logopic);
        attendancecard=view.findViewById(R.id.subcard);
        notifybtn.animate().alpha(5f).translationYBy(60).setDuration(1400);

        firstButton.animate().alpha(5f).translationYBy(60).setDuration(1400);
        internalbutton.animate().alpha(5f).translationYBy(60).setDuration(1400);
        attendancecard.animate().alpha(5f).translationYBy(60).setDuration(1400);
        papercard.animate().alpha(5f).translationYBy(60).setDuration(1400);
        subcard.animate().alpha(5f).translationYBy(60).setDuration(1400);
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.actions);
        propicbig.startAnimation(animation);
        Animation animation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.actions);
        logopic.startAnimation(animation2);
        notifybtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),com.presidency.resultpro.Notifications.class);
                startActivity(intent);
                Bungee.fade(getActivity());
            }
        });
        Glide.with(getActivity()).load(LoginActivity.personPhoto)


                .into(propicbig);


        menuburger.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                menudrawer.drawer.openDrawer(GravityCompat.START);
            }
        });
// perform setOnClickListener on first Button
        internalbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),com.presidency.resultpro.MarksExcelUpload.class);
                startActivity(intent);
                Bungee.split(getActivity());
                Toast.makeText(getActivity(), "Marks", Toast.LENGTH_LONG).show();
            }
        });
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // display a message by using a Toast
                Intent intent = new Intent(getActivity(),com.presidency.resultpro.Graph_Subjects.class);
                startActivity(intent);
                Bungee.fade(getActivity());
                Toast.makeText(getActivity(), "Graphs", Toast.LENGTH_LONG).show();
            }
        });
        return view;
    }

}