package com.ngocollab.event;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.ngocollab.R;

import java.util.Locale;

//Our class extending fragment
public class FragmentDescription extends Fragment {

    FloatingActionButton searchFab;
    TextView event_address_tv;
    LinearLayout event_address_layout;

    Double sourceLatitude = 18.4993, sourceLongitude = 73.8219, destinationLatitude = 18.5196, destinationLongitude = 73.8554;

    //Overriden method onCreateView
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_eventdetails_description_tab, container, false);

        //Fab Button Code
        searchFab = (FloatingActionButton) rootView.findViewById(R.id.fabAttend);
        searchFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity(), "FAB Button Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        //onClicking event address redirect to map to show location
        event_address_tv = (TextView) rootView.findViewById(R.id.event_address_textview);
        event_address_layout = (LinearLayout) rootView.findViewById(R.id.event_address_layout);

        event_address_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?saddr=%f,%f(%s)&daddr=%f,%f (%s)", sourceLatitude, sourceLongitude, "Your Location", destinationLatitude, destinationLongitude, "Event Location");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                intent.setClassName("com.google.android.apps.maps", "com.google.android.maps.MapsActivity");
                startActivity(intent);
            }
        });

        return rootView;
    }
}
