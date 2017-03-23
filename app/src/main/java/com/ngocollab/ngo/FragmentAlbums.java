package com.ngocollab.ngo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ngocollab.R;

/**
 * Created by Abhi on 21-01-2017.
 */

public class FragmentAlbums extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_ngodetails_albums_tab, container, false);
    }
}
