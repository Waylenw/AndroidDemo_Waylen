package com.example.waylenwang.androiddemo_waylen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.waylenwang.androiddemo_waylen.activity.GridRecyclerViewActivity;
import com.example.waylenwang.androiddemo_waylen.activity.LineRecyclerViewActivity;

/**
 * RecyclerView的Demo
 *
 * @author Waylenwang
 */
public class MainActivity extends Activity implements View.OnClickListener{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.lineBtn:
                startActivity(new Intent(getApplicationContext(), LineRecyclerViewActivity.class));
                break;
            case R.id.gridBtn:
                startActivity(new Intent(getApplicationContext(), GridRecyclerViewActivity.class));
                break;
        }
    }
}
