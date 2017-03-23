package com.ngocollab.dashboard;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerDashboard extends FragmentStatePagerAdapter {

    int tabCount;
    private String[] tabTitles = new String[]{"FragmentDashboardTab", "FragmentEventsListTab", "FragmentNotificationTab", "FragmentProfileTab"};

    public PagerDashboard(FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new FragmentDashboardTab();
            case 1:
                return new FragmentEventsListTab();
            case 2:
                return new FragmentNotificationTab();
            case 3:
                return new FragmentProfileTab();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabCount;
    }
}