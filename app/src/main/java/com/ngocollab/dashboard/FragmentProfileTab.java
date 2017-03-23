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
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.ngocollab.R;
import com.ngocollab.ngo.NGOActivity;

import java.util.ArrayList;

public class FragmentProfileTab extends Fragment {

    private RecyclerView vertical_recycler_view;
    private ArrayList<String> verticalList_name_ngo;
    private ArrayList<String> verticalList_location_ngo;
    private VerticalAdapterProfileTab verticalAdapter;
    FloatingActionButton EditProfileFab;

    String[] socialInterest = {"Children", "Environment", "Health"};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard_profile_tab, container, false);

        vertical_recycler_view = (RecyclerView) view.findViewById(R.id.vertical_recycler_view_tab4);
        vertical_recycler_view.setNestedScrollingEnabled(false);
        ListView socialInterestList = (ListView) view.findViewById(R.id.socialInterestList);

        verticalList_name_ngo = new ArrayList<>();
        verticalList_name_ngo.add("Green Peace India Katraj");
        verticalList_name_ngo.add("Child Rights and You (Cry)");
        //verticalList_name_ngo.add("Child Rights and You (Cry)");
        verticalList_name_ngo.add("You (Cry)");

        verticalList_location_ngo = new ArrayList<>();
        verticalList_location_ngo.add("Katraj");
        verticalList_location_ngo.add("Warje");
        //verticalList_location_ngo.add("Warje");
        verticalList_location_ngo.add("pune");


        ArrayAdapter adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_list_item_1, socialInterest);
        socialInterestList.setAdapter(adapter);

        EditProfileFab = (FloatingActionButton) view.findViewById(R.id.fabEditProfile);
        EditProfileFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // Toast.makeText(getActivity(), "FAB Button Clicked", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(FragmentProfileTab.this.getContext(), EditProfileActivity.class);
                startActivity(intent);
            }
        });

        verticalAdapter = new VerticalAdapterProfileTab(verticalList_name_ngo, verticalList_location_ngo, new NgoListClickListener() {
            @Override
            public void onRowViewTap(View view, int position) {
                Intent ngo = new Intent(getActivity(), NGOActivity.class);
                startActivity(ngo);
            }
        });
        LinearLayoutManager verticalLayoutmanager
                = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);

        vertical_recycler_view.setLayoutManager(verticalLayoutmanager);

        vertical_recycler_view.setAdapter(verticalAdapter);
        vertical_recycler_view.setHasFixedSize(true);
        vertical_recycler_view.setNestedScrollingEnabled(false);
        return view;
    }
}
