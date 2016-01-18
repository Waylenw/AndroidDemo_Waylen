package com.example.waylenwang.androiddemo_waylen.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.waylenwang.androiddemo_waylen.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * RecyclerView的适配器
 * <p/>
 * Created by Waylenwang on 2015/8/20.
 */
public class FlowViewAdapter extends RecyclerView.Adapter<FlowViewAdapter.MyViewHolder> {

    List<String> list = new ArrayList<String>();

    private Context context;

    public FlowViewAdapter(Context context) {
        for (int i = 0; i < 100; i++) {
            list.add("列表:" + i);
        }
        this.context = context;
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_item_grid_view, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ViewGroup.LayoutParams layoutParams = holder.imageView.getLayoutParams();
        if(position%3==0){
            layoutParams.height =200;
        }else if(position%3==1){
            layoutParams.height =100;
        }
        else if(position%3==2){
            layoutParams.height =100;

        }
        holder.imageView.setLayoutParams(layoutParams);

    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public MyViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageView);
        }
    }
}
