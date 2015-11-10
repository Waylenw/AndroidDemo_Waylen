package com.example.waylenwang.androiddemo_waylen.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.waylenwang.androiddemo_waylen.R;

import java.util.ArrayList;
import java.util.List;

/**
 * RecyclerView的适配器
 * <p/>
 * Created by Waylenwang on 2015/8/20.
 */
public class GridRecyclerVeiwAdapter extends RecyclerView.Adapter<GridRecyclerVeiwAdapter.MyViewHolder> {

    List<String> list=new ArrayList<String>();

    private Context context;
    public GridRecyclerVeiwAdapter(Context context){
        for(int i=0;i<100;i++){
            list.add("列表:"+i);
        }
        this.context=context;
    }



    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
//        LinearLayout.LayoutParams layoutParams=new LinearLayout.LayoutParams(200,100);
//        holder.tv.setLayoutParams(layoutParams);

    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView tv;

        public MyViewHolder(View view) {
            super(view);
            tv = (ImageView) view.findViewById(R.id.textView);
        }
    }
}
