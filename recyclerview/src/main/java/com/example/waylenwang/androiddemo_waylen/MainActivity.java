package com.example.waylenwang.androiddemo_waylen;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.example.waylenwang.androiddemo_waylen.adapter.FlowViewAdapter;
import com.example.waylenwang.androiddemo_waylen.adapter.GridVeiwAdapter;
import com.example.waylenwang.androiddemo_waylen.adapter.ListViewAdapter;

/**
 * RecyclerView的Demo
 *
 * @author Waylenwang
 */
public class MainActivity extends Activity implements View.OnClickListener {
    private GridVeiwAdapter gridAdapter;
    private ListViewAdapter listAdapter;
    private FlowViewAdapter flowViewAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

    }

    private void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.main_recyclerView);
        gridAdapter = new GridVeiwAdapter(getApplication());
        listAdapter= new ListViewAdapter(getApplication());
        flowViewAdapter= new FlowViewAdapter(getApplication());


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.lineBtn:
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                recyclerView.setAdapter(listAdapter);
                break;
            case R.id.gridBtn:
                recyclerView.setLayoutManager(new GridLayoutManager(this,3));
                recyclerView.setAdapter(gridAdapter);
                break;
            case R.id.flowBtn:
                //StaggeredGridLayoutManager.VERTICAL此处表示有多少列
                recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL));
                recyclerView.setAdapter(flowViewAdapter);
                break;
        }
    }
}
