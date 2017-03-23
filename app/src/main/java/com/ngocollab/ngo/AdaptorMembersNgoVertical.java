package com.ngocollab.ngo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ngocollab.R;

import java.util.List;

public class AdaptorMembersNgoVertical extends RecyclerView.Adapter<AdaptorMembersNgoVertical.MyViewHolderMemberTab> {

    private List<String> list_member_name_tab4;
    private List<String> list_member_designation_tab4;

    public class MyViewHolderMemberTab extends RecyclerView.ViewHolder {
        public TextView name_of_member;
        public TextView designation_of_member;
        public MyViewHolderMemberTab(View view)
        {
            super(view);
            name_of_member = (TextView) view.findViewById(R.id.members_name);
            designation_of_member = (TextView) view.findViewById(R.id.members_designation);
        }
    }

    public AdaptorMembersNgoVertical(List<String> list_member_name_tab4 , List<String> list_member_designation_tab4)
    {
        this.list_member_name_tab4 = list_member_name_tab4;
        this.list_member_designation_tab4 = list_member_designation_tab4;

    }

    @Override
    public AdaptorMembersNgoVertical.MyViewHolderMemberTab onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_ngo_members, parent, false);
        return new MyViewHolderMemberTab(itemView);
    }

    @Override
    public void onBindViewHolder( final AdaptorMembersNgoVertical.MyViewHolderMemberTab holder, final int position) {

        holder.name_of_member.setText(list_member_name_tab4.get(position));
        holder.designation_of_member.setText(list_member_designation_tab4.get(position));

        holder.name_of_member.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),holder.name_of_member.getText().toString(),Toast.LENGTH_SHORT).show();
            }
        });
    }
    @Override
    public int getItemCount() {
        return list_member_name_tab4.size();
    }
}

