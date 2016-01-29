package com.example.fragmentchange2;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created Waylenwang on 2016/1/29.
 * email:
 */
public class MainFragment extends Fragment {

    private int size;

    public static MainFragment newInstance(int page) {
        Bundle args = new Bundle();
        args.putInt("page", page);
        MainFragment pageFragment = new MainFragment();
        pageFragment.setArguments(args);
        return pageFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        size = getArguments().getInt("page");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmen_main, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText("Fragment #" + size);
        return view;
    }

}
