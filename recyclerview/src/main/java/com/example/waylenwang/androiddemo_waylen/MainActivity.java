package com.example.waylenwang.androiddemo_waylen;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
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
public class MainActivity extends Activity {
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
        listAdapter = new ListViewAdapter(getApplication());
        flowViewAdapter = new FlowViewAdapter(getApplication());
        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

        tabLayout.addTab(tabLayout.newTab().setText("ListView效果"));
        tabLayout.addTab(tabLayout.newTab().setText("GridView效果"));
        tabLayout.addTab(tabLayout.newTab().setText("Flow效果"));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() == 0) {//ListView效果
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    recyclerView.setAdapter(listAdapter);
                }
                if (tab.getPosition() == 1) {//GridView效果
                    recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this, 3));
                    recyclerView.setAdapter(gridAdapter);
                }
                if (tab.getPosition() == 2) {//Flow效果
                    //StaggeredGridLayoutManager.VERTICAL此处表示有多少列
                    recyclerView.setLayoutManager(new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL));
                    recyclerView.setAdapter(flowViewAdapter);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);


    }
}
