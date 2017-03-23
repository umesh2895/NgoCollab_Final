package com.ngocollab.dashboard;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ngocollab.R;

import java.util.List;

public class ExploreNgoListAdapter extends RecyclerView.Adapter<ExploreNgoListAdapter.MyViewHolder> {

    private List<String> horizontalList;
    NgoListClickListener listener;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView txtView;
        public ImageView imageView1;

        public MyViewHolder(View view) {
            super(view);
            txtView = (TextView) view.findViewById(R.id.tv);
            imageView1 = (ImageView) view.findViewById(R.id.iv);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onRowViewTap(view, getAdapterPosition());
                }
            });

        }
    }

    public ExploreNgoListAdapter(List<String> horizontalList, NgoListClickListener listener) {
        this.horizontalList = horizontalList;
        this.listener = listener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.ngo_list_grid_item_view, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.txtView.setText(horizontalList.get(position));
    }

    @Override
    public int getItemCount() {
        return horizontalList.size();
    }
}