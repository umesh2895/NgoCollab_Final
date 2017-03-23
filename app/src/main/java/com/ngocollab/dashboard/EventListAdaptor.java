package com.ngocollab.dashboard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ngocollab.R;

import java.util.List;

/**
 * Created by Abhi on 22-01-2017.
 */

public class EventListAdaptor extends RecyclerView.Adapter<EventListAdaptor.MyViewHolder> {

    private List<String> verticalList_name_of_ngo, verticalList_time, verticalList_address, verticalList_name_of_event;
    EventListClickListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView eventName, ngoName, eventTime, eventPlace;

        public MyViewHolder(View view) {
            super(view);
            eventName = (TextView) view.findViewById(R.id.popular_event_card_event_name);
            ngoName = (TextView) view.findViewById(R.id.popular_event_card_ngo_name);
            eventTime = (TextView) view.findViewById(R.id.popular_event_card_time);
            eventPlace = (TextView) view.findViewById(R.id.popular_event_card_place);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onRowViewTap(view, getAdapterPosition());
                }
            });
        }
    }

    public EventListAdaptor(List<String> verticalList_name_of_ngo, List<String> verticalList_name_of_event, List<String> verticalList_time, List<String> verticalList_address, EventListClickListener listener) {
        this.verticalList_name_of_ngo = verticalList_name_of_ngo;
        this.verticalList_name_of_event = verticalList_name_of_event;
        this.verticalList_time = verticalList_time;
        this.verticalList_address = verticalList_address;
        this.listener = listener;
    }

    @Override
    public EventListAdaptor.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.popular_event_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final EventListAdaptor.MyViewHolder holder, final int position) {
        holder.ngoName.setText(verticalList_name_of_ngo.get(position));
        holder.eventName.setText(verticalList_name_of_event.get(position));
        holder.eventTime.setText(verticalList_time.get(position));
        holder.eventPlace.setText(verticalList_address.get(position));
    }

    @Override
    public int getItemCount() {
        return verticalList_name_of_event.size();
    }
}
