package com.ngocollab.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ngocollab.R;
import com.ngocollab.event.EventActivity;

import java.util.ArrayList;

public class FragmentEventsListTab extends Fragment {

    private RecyclerView vertical_recycler_view_tab1, vertical_recycler_view_tab2;
    private ArrayList<String> verticalList_name_of_ngo, verticalList_time, verticalList_address, verticalList_name_of_event;
    private EventListAdaptor verticalAdapterEvent;
    FloatingActionButton AddEvent;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard_event_list_tab, container, false);

        verticalList_name_of_ngo = new ArrayList<>();
        verticalList_name_of_ngo.add("Kartvya");
        verticalList_name_of_ngo.add("Ugam");
        verticalList_name_of_ngo.add("Sawali Foundation");

        verticalList_name_of_event = new ArrayList<>();
        verticalList_name_of_event.add("Clean India Initiative");
        verticalList_name_of_event.add("Rainwater Harvesting");
        verticalList_name_of_event.add("Yoga Day");

        verticalList_time = new ArrayList<>();
        verticalList_time.add("10:00am to 01:30pm");
        verticalList_time.add("10:01am to 01:30pm");
        verticalList_time.add("05:00am to 07:30am");


        verticalList_address = new ArrayList<>();
        verticalList_address.add("Synerzip, Warje");
        verticalList_address.add("SNDT, Karve Nagar");
        verticalList_address.add("Arai Tekdi, Kothrud");

        vertical_recycler_view_tab1 = (RecyclerView)view.findViewById(R.id.vertical_recycler_view1);
        AddEvent = (FloatingActionButton) view.findViewById(R.id.addevents);
        AddEvent.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
            }
        });

        verticalAdapterEvent = new EventListAdaptor(verticalList_name_of_ngo, verticalList_name_of_event, verticalList_time, verticalList_address, new EventListClickListener() {
            @Override
            public void onRowViewTap(View view, int position) {
                Intent event = new Intent(getActivity(), EventActivity.class);
                startActivity(event);
            }
        });
        vertical_recycler_view_tab1.setHasFixedSize(true);

        LinearLayoutManager verticalLayoutManager
                = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);

        vertical_recycler_view_tab1.setLayoutManager(verticalLayoutManager);
        vertical_recycler_view_tab1.setAdapter(verticalAdapterEvent);
        vertical_recycler_view_tab1.setNestedScrollingEnabled(false);

//  Recycler View 2
//        vertical_recycler_view_tab2 = (RecyclerView)view.findViewById(R.id.vertical_recycler_view2);
//        AddEvent = (FloatingActionButton) view.findViewById(R.id.addevents);
//        AddEvent.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent event = new Intent(getActivity(), EventActivity.class);
//                startActivity(event);
//            }
//        });
//
//        verticalAdapterEvent = new EventListAdaptor(verticalList_name_of_ngo, verticalList_name_of_event , verticalList_time , verticalList_address );
//        vertical_recycler_view_tab2.setNestedScrollingEnabled(false);
//        vertical_recycler_view_tab2.setHasFixedSize(true);
//
//        LinearLayoutManager verticalLayoutmanager1
//                = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);
//
//        vertical_recycler_view_tab2.setLayoutManager(verticalLayoutmanager1);
//        vertical_recycler_view_tab2.setAdapter(verticalAdapterEvent);
//        vertical_recycler_view_tab2.setNestedScrollingEnabled(false);
        return view;
    }
}
