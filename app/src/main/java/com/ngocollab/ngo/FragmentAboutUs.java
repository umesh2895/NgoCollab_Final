package com.ngocollab.ngo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ngocollab.R;

/**
 * Created by Abhi on 21-01-2017.
 */

public class FragmentAboutUs extends Fragment {
    FloatingActionButton AddEvent;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ngodetails_about_us, container, false);


        AddEvent = (FloatingActionButton) view.findViewById(R.id.addevents);
        AddEvent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity(), "FAB Button Clicked", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(FragmentEvents.this.getContext(), EditProfileActivity.class);
                //startActivity(intent);


            }
        });
        return view;
    }
}

