package com.ngocollab.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ngocollab.R;

public class SocialInterestAdapter extends BaseAdapter {

    private final Context mContext;
    private final UserSocialInterest[] usrInterests;

    public SocialInterestAdapter(Context context, UserSocialInterest[] usrInterests) {
        this.mContext = context;
        this.usrInterests = usrInterests;
    }

    @Override
    public int getCount() {
        return usrInterests.length;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final UserSocialInterest usrInterest = usrInterests[position];

        if (convertView == null) {
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.linearlayout_social_interest, null);

            final ImageView imageViewCoverArt = (ImageView) convertView.findViewById(R.id.imageview_cover_art);
            final TextView nameTextView = (TextView) convertView.findViewById(R.id.textview_interest_name);

            final ViewHolder viewHolder = new ViewHolder(nameTextView, imageViewCoverArt);
            convertView.setTag(viewHolder);
        }

        final ViewHolder viewHolder = (ViewHolder) convertView.getTag();
        viewHolder.imageViewCoverArt.setImageResource(usrInterest.getImageResource());
        viewHolder.nameTextView.setText(usrInterest.getName());
        return convertView;
    }

    private class ViewHolder {
        private final TextView nameTextView;
        private final ImageView imageViewCoverArt;

        public ViewHolder(TextView nameTextView, ImageView imageViewCoverArt) {
            this.nameTextView = nameTextView;
            this.imageViewCoverArt = imageViewCoverArt;
        }
    }

}

