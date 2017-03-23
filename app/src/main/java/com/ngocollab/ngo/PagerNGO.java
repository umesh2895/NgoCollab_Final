package com.ngocollab.ngo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by Abhi on 21-01-2017.
 */
//Extending FragmentStatePagerAdapter
public class PagerNGO extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;
    private String[] tabTitles = new String[]{"About Us", "Events", "Albums", "Members"};
    //Constructor to the class
    public PagerNGO(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }


    // overriding getPageTitle()

    /* you can add name to tab instead only icon i.e. text with icon */
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }



    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                FragmentAboutUs tab1 = new FragmentAboutUs();
                return tab1;
            case 1:
                FragmentEvents tab2 = new FragmentEvents();
                return tab2;
            case 2:
                FragmentAlbums tab3 = new FragmentAlbums();
                return tab3;
            case 3:
                FragmentMembers tabProfileFragment = new FragmentMembers();
                return tabProfileFragment;
            default:
                return null;
        }
    }

    //Overriden method getCount to get the number of tabs
    @Override
    public int getCount() {
        return tabCount;
    }
}
