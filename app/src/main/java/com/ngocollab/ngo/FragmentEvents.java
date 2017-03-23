package com.ngocollab.ngo;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.ngocollab.R;

import java.util.ArrayList;

/**
 * Created by Abhi on 21-01-2017.
 */

public class FragmentEvents extends Fragment {


    private RecyclerView vertical_recycler_view_tab2;
    private ArrayList<String> verticalList_day_date;
    private ArrayList<String> verticalList_time;
    private ArrayList<String> verticalList_address;
    private ArrayList<String> verticalList_name_of_event;
    private AdaptorNGOsEvents verticalAdapterEvent;
    FloatingActionButton AddEvent;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ngodetails_events_tab, container, false);

        vertical_recycler_view_tab2 = (RecyclerView) view.findViewById(R.id.vertical_recycler_view_tab2Events);

        verticalList_name_of_event = new ArrayList<>();
        verticalList_name_of_event.add("Name of event 1");
        verticalList_name_of_event.add("Name of event 2");
        verticalList_name_of_event.add("Name of event 1");
        verticalList_name_of_event.add("Name of event 2");
        verticalList_name_of_event.add("Name of event 1");
        verticalList_name_of_event.add("Name of event 2");


        verticalList_day_date = new ArrayList<>();
        verticalList_day_date.add("Saturday,Jan 14");
        verticalList_day_date.add("Monday,Jan 15");
        verticalList_day_date.add("Saturday,Jan 14");
        verticalList_day_date.add("Monday,Jan 15");
        verticalList_day_date.add("Saturday,Jan 14");
        verticalList_day_date.add("Monday,Jan 15");

        verticalList_time = new ArrayList<>();
        verticalList_time.add("10:00am to 01:30pm");
        verticalList_time.add("10:01am to 01:30pm");
        verticalList_time.add("10:00am to 01:30pm");
        verticalList_time.add("10:01am to 01:30pm");
        verticalList_time.add("10:00am to 01:30pm");
        verticalList_time.add("10:01am to 01:30pm");


        verticalList_address = new ArrayList<>();
        verticalList_address.add("Synerzip , Warje");
        verticalList_address.add("Synerzipp , Warje");
        verticalList_address.add("Synerzip , Warje");
        verticalList_address.add("Synerzipp , Warje");
        verticalList_address.add("Synerzip , Warje");
        verticalList_address.add("Synerzipp , Warje");


        AddEvent = (FloatingActionButton) view.findViewById(R.id.addevents);
        AddEvent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity(), "FAB Button Clicked", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(FragmentEvents.this.getContext(), EditProfileActivity.class);
                //startActivity(intent);


            }
        });


        verticalAdapterEvent = new AdaptorNGOsEvents(verticalList_name_of_event, verticalList_day_date, verticalList_time, verticalList_address);

        vertical_recycler_view_tab2.setHasFixedSize(true);

        LinearLayoutManager verticalLayoutmanager
                = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);

        vertical_recycler_view_tab2.setLayoutManager(verticalLayoutmanager);
        vertical_recycler_view_tab2.setAdapter(verticalAdapterEvent);
        vertical_recycler_view_tab2.setNestedScrollingEnabled(false);
        return view;
    }
}
