package com.ngocollab.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ngocollab.R;
import com.ngocollab.login.LoginActivity;
import com.ngocollab.signup.GetLocationActivity;

public class DashboardActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener {
    Toolbar toolbar;
    boolean doubleBackToExitPressedOnce = false;

    private int[] tabIconsList = new int[]{R.drawable.ic_dashboard_white, R.drawable.ic_action_event_white, R.drawable.ic_action_notification,
            R.drawable.ic_action_profile_white};

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

//        toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText("FragmentDashboardTab"));
        tabLayout.addTab(tabLayout.newTab().setText("FragmentEventsListTab"));
        tabLayout.addTab(tabLayout.newTab().setText("FragmentNotificationTab"));
        tabLayout.addTab(tabLayout.newTab().setText("FragmentProfileTab"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.pager);
        PagerDashboard adapter = new PagerDashboard(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            tabLayout.getTabAt(i).setIcon(tabIconsList[i]);
        }
        tabLayout.setOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
        invalidateOptionsMenu();
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {
    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_dashboard, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case R.id.action_aboutus:
                Intent intentAboutUs = new Intent(DashboardActivity.this, LoginActivity.class);
                startActivity(intentAboutUs);
                finish();
                return true;

            case R.id.action_settings:
                Intent intentSettings = new Intent(DashboardActivity.this, LoginActivity.class);
                startActivity(intentSettings);
                finish();
                return true;

            case R.id.action_logout:
                Intent intentLogOut = new Intent(DashboardActivity.this, LoginActivity.class);
                startActivity(intentLogOut);
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press again to exit", Toast.LENGTH_SHORT).show();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 2000);
    }
}
