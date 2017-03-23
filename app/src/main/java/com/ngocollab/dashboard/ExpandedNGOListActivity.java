package com.ngocollab.dashboard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.ngocollab.R;
import com.ngocollab.ngo.NGOActivity;

import java.util.ArrayList;

public class ExpandedNGOListActivity extends AppCompatActivity {

    private RecyclerView NGOGridRecyclerView;
    private ArrayList<String> NGOList;
    private ExpandedNGOGridListAdapter expandedNGOGridListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expanded_ngolist) ;
        //Adding toolbar to the activity

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        //popular NGOs display in cardview (RecyclerView) as horizontal
        NGOGridRecyclerView = (RecyclerView)findViewById(R.id.expanded_NGO_list_recycler_view);
        NGOList = new ArrayList<>();
        NGOList.add("Green Peace India");
        NGOList.add("Child Rights and You");
        NGOList.add("Save Water Campaign");
        NGOList.add("Unnati NGO");
        NGOList.add("Mera India");
        NGOList.add("Indian NGO");
        NGOList.add("Maharashtra NGO");
        NGOList.add("Green World NGO");

        expandedNGOGridListAdapter = new ExpandedNGOGridListAdapter(NGOList, new NgoListClickListener() {
            @Override
            public void onRowViewTap(View view, int position) {
                Intent ngo = new Intent(ExpandedNGOListActivity.this, NGOActivity.class);
                startActivity(ngo);
            }
        });
        NGOGridRecyclerView.setAdapter(expandedNGOGridListAdapter);

        //Grid layout for listing popular ngos
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
        NGOGridRecyclerView.setLayoutManager(gridLayoutManager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
