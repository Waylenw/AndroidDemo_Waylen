package com.example.waylenwang.androiddemo_waylen.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.waylenwang.androiddemo_waylen.R;
import com.example.waylenwang.androiddemo_waylen.adapter.MyRecyclerVeiwTwoAdapter;

/**
 * 单行的RecyclerView
 *
 * @author Waylenwang
 */
public class LineRecyclerViewActivity extends Activity {
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_layout);


        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerView);

        MyRecyclerVeiwTwoAdapter recyclerVeiwAdapter2 = new MyRecyclerVeiwTwoAdapter(getApplication());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerVeiwAdapter2);
    }


}
