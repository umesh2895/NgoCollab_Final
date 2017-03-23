package com.ngocollab.event;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

//Extending FragmentStatePagerAdapter
public class PagerEvent extends FragmentStatePagerAdapter {

    //integer to count number of tabs
    int tabCount;
    private String[] tabTitles = new String[]{"Description", "Photos"};
    //Constructor to the class
    public PagerEvent(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabCount= tabCount;
    }


    // overriding getPageTitle()
    // setting name to tab
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
                FragmentDescription tab1 = new FragmentDescription();
                return tab1;
            case 1:
                FragmentPhotos tab2 = new FragmentPhotos();
                return tab2;
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