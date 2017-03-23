package com.ngocollab.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.ngocollab.R;
import com.ngocollab.ngo.NGOActivity;

import java.util.ArrayList;

public class FragmentDashboardTab extends Fragment {

    private ArrayList<String> horizontalList;
    FloatingActionButton searchFab;

    private UserSocialInterest[] userInterests = {
            new UserSocialInterest("Tree Plantation", R.drawable.tree),
            new UserSocialInterest("Save Water", R.drawable.save_water),
            new UserSocialInterest("Clean India", R.drawable.clean_india),
            new UserSocialInterest("Save Girl Child", R.drawable.save_girls),
            new UserSocialInterest("Blood Donation", R.drawable.blood_donation),
            new UserSocialInterest("Food Donation", R.drawable.food),
            new UserSocialInterest("Rural Education", R.drawable.rural_education)};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dashoard_tab, container, false);

        RecyclerView horizontal_recycler_view = (RecyclerView) view.findViewById(R.id.horizontal_recycler_view);
        horizontalList = new ArrayList<>();
        horizontalList.add("Green Peace India");
        horizontalList.add("Child Rights and You");
        horizontalList.add("Save Water Campaign");
        horizontalList.add("Unnati NGO");
        horizontalList.add("Mera India");
        horizontalList.add("Indian NGO");
        horizontalList.add("Maharashtra NGO");
        horizontalList.add("Green World NGO");

        PopularNGOsHorizontalAdapter popularNGOsHorizontalAdapter = new PopularNGOsHorizontalAdapter(horizontalList, new NgoListClickListener() {
            @Override
            public void onRowViewTap(View view, int position) {
                Intent ngo = new Intent(getActivity(), NGOActivity.class);
                startActivity(ngo);
            }
        });

        LinearLayoutManager horizontalLayoutManager
                = new LinearLayoutManager(view.getContext(), LinearLayoutManager.HORIZONTAL, false);
        horizontal_recycler_view.setLayoutManager(horizontalLayoutManager);
        horizontal_recycler_view.setAdapter(popularNGOsHorizontalAdapter);

        Button morePopularNGOs = (Button) view.findViewById(R.id.moreButtonId);
        morePopularNGOs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent expandedNGOListActivity = new Intent(getActivity(), ExpandedNGOListActivity.class);
                startActivity(expandedNGOListActivity);
            }
        });

        searchFab = (FloatingActionButton) view.findViewById(R.id.fabSearch);
        searchFab.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                final View inflate = getActivity().getLayoutInflater().inflate(R.layout.custom_alert_dialog, null);
                builder.setView(inflate);

                final ListView listView = (ListView) inflate.findViewById(R.id.dialog_listview);
                String[] dialogList = new String[]{"Register NGO", "Create Event"};
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(),
                        android.R.layout.simple_list_item_single_choice, android.R.id.text1, dialogList);
                listView.setAdapter(adapter);
                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        String itemValue = (String) listView.getItemAtPosition(position);
                        Toast.makeText(getContext(), "" + itemValue, Toast.LENGTH_LONG).show();
                    }
                });

                final AlertDialog alertDialog = builder.create();
                Window window = alertDialog.getWindow();
                assert window != null;
                window.setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                window.setGravity(Gravity.CENTER);
                Button cancel_btn = (Button) inflate.findViewById(R.id.dialog_cancellist);
                cancel_btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        alertDialog.dismiss();
                    }
                });
                alertDialog.show();
            }
        });

        ExploreGridView gridView = (ExploreGridView) view.findViewById(R.id.gridview);
        final SocialInterestAdapter exploreAdapter = new SocialInterestAdapter(view.getContext(), userInterests);
        gridView.setExpanded(true);
        gridView.setAdapter(exploreAdapter);
        exploreAdapter.notifyDataSetChanged();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent exploreNgoActivity = new Intent(getActivity(), ExploreNgoActivity.class);
                startActivity(exploreNgoActivity);
            }
        });
        return view;
    }
}