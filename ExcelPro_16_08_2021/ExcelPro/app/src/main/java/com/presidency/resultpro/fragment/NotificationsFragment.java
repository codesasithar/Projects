package com.presidency.resultpro.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.presidency.resultpro.R;

import spencerstudios.com.bungeelib.Bungee;

public class NotificationsFragment extends Fragment {

    View view;
    CardView firstButton;
    CardView internalbutton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

// Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_notificationchoice, container, false);
        firstButton = view.findViewById(R.id.cgg1);
        internalbutton = view.findViewById(R.id.cgg2);
// get the reference of Button


        firstButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), com.presidency.resultpro.teachernotifications.class);
                startActivity(intent);
                Bungee.fade(getActivity());
            }
        });
        //    Glide.with(getActivity()).load(LoginActivity.personPhoto)


        //     .into(propicbig);


// perform setOnClickListener on first Button
        internalbutton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), com.presidency.resultpro.Notifications.class);
                startActivity(intent);
                Bungee.split(getActivity());
                Toast.makeText(getActivity(), "Marks", Toast.LENGTH_LONG).show();
            }
        });

return view;
    }
}