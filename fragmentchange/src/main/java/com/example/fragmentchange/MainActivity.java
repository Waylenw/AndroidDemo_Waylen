package com.example.fragmentchange;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private LinearLayout tab1, tab2, tab3;
    private int currentIndex = 0;
    private ArrayList<Fragment> fragmentArrayList;
    private Fragment mCurrentFrgment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initFragment();
    }


    private void initView() {
        tab1 = (LinearLayout) findViewById(R.id.tab1);
        tab1.setOnClickListener(this);
        tab1.setTag(0);

        tab2 = (LinearLayout) findViewById(R.id.tab2);
        tab2.setOnClickListener(this);
        tab2.setTag(1);

        tab3 = (LinearLayout) findViewById(R.id.tab3);
        tab3.setOnClickListener(this);
        tab3.setTag(2);
    }

    private void initFragment() {
        FragmentTransaction frgmentTransation = getSupportFragmentManager().beginTransaction();
        fragmentArrayList = new ArrayList<Fragment>(3);
        fragmentArrayList.add(new Tab1Fragment());
        fragmentArrayList.add(new Tab2Fragment());
        fragmentArrayList.add(new Tab3Fragment());

        tab1.setSelected(true);

        changeTab(0);
    }


    @Override
    public void onClick(View v) {
        changeTab((Integer) v.getTag());

    }

    private void changeTab(int index) {
        currentIndex = index;
        tab1.setSelected(index == 0);
        tab2.setSelected(index == 1);
        tab3.setSelected(index == 2);

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //判断当前的Fragment是否为空，不为空则隐藏
        if (null != mCurrentFrgment) {
            ft.hide(mCurrentFrgment);
        }
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(fragmentArrayList.get(currentIndex).getClass().getName());

        if (null == fragment) {
            fragment = fragmentArrayList.get(index);
        }
        mCurrentFrgment = fragment;

        if (!fragment.isAdded()) {
            ft.add(R.id.fragment, fragment, fragment.getClass().getName());
        } else {
            ft.show(fragment);
        }
        ft.commitAllowingStateLoss();
    }
}
