package com.ngocollab.ngo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.ngocollab.R;

import java.util.List;

/**
 * Created by Abhi on 22-01-2017.
 */

public class AdaptorNGOsEvents extends RecyclerView.Adapter<AdaptorNGOsEvents.MyViewHolder> {

    private List<String> verticalList_day_date;
    private List<String> verticalList_time;
    private List<String> verticalList_address;
    private List<String> verticalList_name_of_event;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView details_name_of_event;
        public ImageView icon_day_date_event;
        public TextView day_date_event;
        public TextView time_event;
        public ImageView icon_location_event;
        public TextView address_event;

        public MyViewHolder(View view) {
            super(view);
            details_name_of_event = (TextView) view.findViewById(R.id.detail_name_of_event_ngo_event);
            icon_day_date_event = (ImageView) view.findViewById(R.id.icon_time_specific_ngo_event);
            day_date_event = (TextView) view.findViewById(R.id.date_day_event_specific_ngo_event);
            time_event = (TextView) view.findViewById(R.id.time_event_specific_ngo_event);
            icon_location_event = (ImageView) view.findViewById(R.id.icon_place_specific_ngo_event);
            address_event = (TextView) view.findViewById(R.id.address_event_specific_ngo_event);
        }
    }

    public AdaptorNGOsEvents(List<String> verticalList_name_of_event, List<String> verticalList_day_date, List<String> verticalList_time, List<String> verticalList_address) {
        this.verticalList_name_of_event = verticalList_name_of_event;
        this.verticalList_day_date = verticalList_day_date;
        this.verticalList_time = verticalList_time;
        this.verticalList_address = verticalList_address;
    }

    @Override
    public AdaptorNGOsEvents.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ngo_event_page_detail_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final AdaptorNGOsEvents.MyViewHolder holder, final int position) {
        holder.details_name_of_event.setText(verticalList_name_of_event.get(position));
        holder.day_date_event.setText(verticalList_day_date.get(position));
        holder.time_event.setText(verticalList_time.get(position));
        holder.address_event.setText(verticalList_address.get(position));
        holder.details_name_of_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), holder.details_name_of_event.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return verticalList_name_of_event.size();
    }
}
