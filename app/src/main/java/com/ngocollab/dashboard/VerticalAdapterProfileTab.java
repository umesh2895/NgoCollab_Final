package com.ngocollab.dashboard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ngocollab.R;

import java.util.List;

/**
 * Created by Abhi on 14-01-2017.
 */

public class VerticalAdapterProfileTab extends RecyclerView.Adapter<VerticalAdapterProfileTab.MyViewHolder> {

    private List<String> verticalList_name_ngo;
    private List<String> verticalList_location_ngo;
    NgoListClickListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public ImageView icon_profile;
        public TextView name_ngo_profile;
        public ImageView icon_location;
        public TextView location_name;

        public MyViewHolder(View view) {
            super(view);
            icon_profile = (ImageView) view.findViewById(R.id.icon_ngo_profilepage);
            name_ngo_profile = (TextView) view.findViewById(R.id.name_ngo_profilepage);
            icon_location = (ImageView) view.findViewById(R.id.icon_place_profilepage);
            location_name = (TextView) view.findViewById(R.id.place_name_ngo_profilepage);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onRowViewTap(view, getAdapterPosition());
                }
            });
        }
    }

    public VerticalAdapterProfileTab(List<String> verticalList_name_ngo, List<String> verticalList_location_ngo, NgoListClickListener listener) {
        this.verticalList_name_ngo = verticalList_name_ngo;
        this.verticalList_location_ngo = verticalList_location_ngo;
        this.listener = listener;
    }

    @Override
    public VerticalAdapterProfileTab.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.profile_tab_ngo_list_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final VerticalAdapterProfileTab.MyViewHolder holder, final int position) {
        holder.name_ngo_profile.setText(verticalList_name_ngo.get(position));
        holder.location_name.setText(verticalList_location_ngo.get(position));
    }

    public int getItemCount() {
        return verticalList_name_ngo.size();
    }
}
