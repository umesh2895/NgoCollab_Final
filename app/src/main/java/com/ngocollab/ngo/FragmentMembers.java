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

public class FragmentMembers extends Fragment {

    private RecyclerView recyclerViewForMembersTab4;
    private AdaptorMembersNgoVertical verticalAdapterMembers;
    private ArrayList<String> list_name_of_member;
    private ArrayList<String> list_designation_of_memeber;
    FloatingActionButton AddMember;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ngodetails_members_tab, container, false);
        recyclerViewForMembersTab4 = (RecyclerView) view.findViewById(R.id.vertical_recycler_view_tab4_members);

        list_name_of_member = new ArrayList<>();
        list_name_of_member.add("Abhishek Saitwal");
        list_name_of_member.add("Gaurav Patil");
        list_name_of_member.add("Umesh Rathi");
        list_name_of_member.add("Abhishek Saitwal");
        list_name_of_member.add("Gaurav Patil");
        list_name_of_member.add("Umesh Rathi");


        list_designation_of_memeber = new ArrayList<>();
        list_designation_of_memeber.add("Manager");
        list_designation_of_memeber.add("Admin");
        list_designation_of_memeber.add("Admin");
        list_designation_of_memeber.add("");
        list_designation_of_memeber.add("");
        list_designation_of_memeber.add("");

        AddMember = (FloatingActionButton) view.findViewById(R.id.add_member_fab_button);
        AddMember.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Add Members", Toast.LENGTH_SHORT).show();
            }
        });


        verticalAdapterMembers = new AdaptorMembersNgoVertical(list_name_of_member , list_designation_of_memeber);
        recyclerViewForMembersTab4.setHasFixedSize(true);
        LinearLayoutManager verticalLayoutmanagermembertab
                = new LinearLayoutManager(view.getContext(), LinearLayoutManager.VERTICAL, false);

        recyclerViewForMembersTab4.setLayoutManager(verticalLayoutmanagermembertab);
        recyclerViewForMembersTab4.setAdapter(verticalAdapterMembers);
        return view;
    }
}
