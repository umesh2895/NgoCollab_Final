package com.ngocollab.dashboard;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.ngocollab.R;
import com.ngocollab.ngo.NGOActivity;

import java.util.ArrayList;

public class ExploreNgoActivity extends AppCompatActivity {

    private RecyclerView NGOGridRecyclerView;
    private ArrayList<String> NGOList;
    private ExploreNgoListAdapter expandedNGOGridListAdapter;
    Button buttonFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore_ngo);
        //Adding toolbar to the activity

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        //popular NGOs display in cardview (RecyclerView) as horizontal
        NGOGridRecyclerView = (RecyclerView) findViewById(R.id.expanded_NGO_list_recycler_view);
        NGOList = new ArrayList<>();
        NGOList.add("Green Peace India");
        NGOList.add("Child Rights and You");
        NGOList.add("Save Water Campaign");
        NGOList.add("Unnati NGO");
        NGOList.add("Mera India");
        NGOList.add("Indian NGO");
        NGOList.add("Maharashtra NGO");
        NGOList.add("Green World NGO");

        expandedNGOGridListAdapter = new ExploreNgoListAdapter(NGOList, new NgoListClickListener() {
            @Override
            public void onRowViewTap(View view, int position) {
                Intent ngo = new Intent(ExploreNgoActivity.this, NGOActivity.class);
                startActivity(ngo);
            }
        });
        NGOGridRecyclerView.setAdapter(expandedNGOGridListAdapter);

        //Grid layout for listing popular ngos
        RecyclerView.LayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(), 2);
        NGOGridRecyclerView.setLayoutManager(gridLayoutManager);

        buttonFilter = (Button) findViewById(R.id.buttonFilter);
        buttonFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ExploreNgoActivity.this);
                final LayoutInflater inflater = getLayoutInflater();
                view = inflater.inflate(R.layout.dialog_filter_listview, null);
                String[] categories = {
                        "Tree Plantation",
                        "Save Water",
                        "Clean India",
                        "Save Girl Child",
                        "Blood Donation",
                        "Food Donation",
                        "Rural Education"
                };

                final ListView listview = (ListView) view.findViewById(R.id.filters_listview);
                final SparseBooleanArray[] sparseBooleanArray = new SparseBooleanArray[1];
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(ExploreNgoActivity.this, android.R.layout.simple_list_item_multiple_choice, categories);
                listview.setAdapter(adapter);

                listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                        sparseBooleanArray[0] = listview.getCheckedItemPositions();
//                        String ValueHolder = "";
//                        int i = 0;
//                        while (i < sparseBooleanArray[0].size()) {
//                            if (sparseBooleanArray[0].valueAt(i)) {
//                                ValueHolder += city[sparseBooleanArray[0].keyAt(i)] + ",";
//                            }
//                            i++;
//                        }
//                        ValueHolder = ValueHolder.replaceAll("(,)*$", "");
                    }
                });

                builder.setView(view)
                        .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        });
                builder.create();
                builder.show();
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_explore_ngo, menu);
//        return true;
//    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
