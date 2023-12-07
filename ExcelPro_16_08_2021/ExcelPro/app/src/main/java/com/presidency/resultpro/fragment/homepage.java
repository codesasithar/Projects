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

import com.presidency.resultpro.MainActivityfirst;
import com.presidency.resultpro.R;

import spencerstudios.com.bungeelib.Bungee;

public class homepage extends Fragment {

    View view;
    CardView firstButton;
    CardView internalbutton,cggraph;
    CardView notifybtn, eventscard,papercard,subcard;
    public ImageView logopic,propicbig;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_dashboard, container, false);
// get the reference of Button
        ImageView menuburger=view.findViewById(R.id.menuburger);
        firstButton =  view.findViewById(R.id.cggraph);
        internalbutton = view.findViewById(R.id.cdmarks);
        notifybtn=view.findViewById(R.id.cardnotify);
        propicbig=view.findViewById(R.id.imageView7);
        papercard=view.findViewById(R.id.cardfeed);
        subcard=view.findViewById(R.id.subcard);
        logopic=view.findViewById(R.id.logopic);
        cggraph=view.findViewById(R.id.cggraph);
        eventscard =view.findViewById(R.id.attendancecard);
        notifybtn.animate().alpha(5f).translationYBy(60).setDuration(1400);

        firstButton.animate().alpha(5f).translationYBy(60).setDuration(1400);
        internalbutton.animate().alpha(5f).translationYBy(60).setDuration(1400);
        eventscard.animate().alpha(5f).translationYBy(60).setDuration(1400);
        papercard.animate().alpha(5f).translationYBy(60).setDuration(1400);
        subcard.animate().alpha(5f).translationYBy(60).setDuration(1400);
        //  Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.actions);
//        propicbig.startAnimation(animation);
        Animation animation2 = AnimationUtils.loadAnimation(getActivity(), R.anim.actions);
        logopic.startAnimation(animation2);
        notifybtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),com.presidency.resultpro.notificationchoice.class);
                startActivity(intent);
                Bungee.fade(getActivity());
            }
        });
        //    Glide.with(getActivity()).load(LoginActivity.personPhoto)


        //     .into(propicbig);


        menuburger.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivityfirst.drawer.openDrawer(GravityCompat.START);
            }
        });
        internalbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),com.presidency.resultpro.StudentResults.class);
                startActivity(intent);
                Bungee.split(getActivity());

            }
        });


        subcard.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sub= new Intent(getActivity(),com.presidency.resultpro.Subjects.class);
                startActivity(sub);
            }
        });
        eventscard.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),com.presidency.resultpro.EventsActivity.class);
                startActivity(intent);
                Bungee.split(getActivity());

            }
        });


        papercard.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent connectfeedback= new Intent(getActivity(),com.presidency.resultpro.FeedbackSender.class);
                startActivity(connectfeedback);
            }
        });
        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // display a message by using a Toast
                Intent intent = new Intent(getActivity(),com.presidency.resultpro.Graph_Subjects.class);
                startActivity(intent);
                Bungee.fade(getActivity());

            }
        });

        return view;

    }

}