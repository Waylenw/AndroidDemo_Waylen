package com.example.waylenwang.androiddemo_waylen;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * RecyclerView的Demo
 *
 * @author Waylenwang
 *
 */
public class MainActivity extends Activity {
    private RecyclerView recyclerView;
    private RecyclerView recyclerView1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView=(RecyclerView)findViewById(R.id.main_recyclerView);
        recyclerView1=(RecyclerView)findViewById(R.id.main_recyclerView1);

        MyRecyclerVeiwAdapter recyclerVeiwAdapter=new MyRecyclerVeiwAdapter(getApplication());
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        recyclerView.setAdapter(recyclerVeiwAdapter);

        MyRecyclerVeiwTwoAdapter recyclerVeiwAdapter2=new MyRecyclerVeiwTwoAdapter(getApplication());
        recyclerView1.setLayoutManager(new LinearLayoutManager(this));
        recyclerView1.setAdapter(recyclerVeiwAdapter2);
    }


}
