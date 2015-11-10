package com.example.waylenwang.androiddemo_waylen.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.waylenwang.androiddemo_waylen.R;
import com.example.waylenwang.androiddemo_waylen.adapter.GridRecyclerVeiwAdapter;

/**
 * 网格的RecyclerView
 *
 * @author Waylenwang
 */
public class GridRecyclerViewActivity extends Activity {
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_layout);


        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerView);

        GridRecyclerVeiwAdapter recyclerVeiwAdapter2 = new GridRecyclerVeiwAdapter(getApplication());
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(recyclerVeiwAdapter2);
    }


}
