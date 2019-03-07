package com.test.mymvpdemo.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;

import com.test.mymvpdemo.R;
import com.test.mymvpdemo.adapter.MainFragmentAdapter;
import com.test.mymvpdemo.base.BaseActivity;
import com.test.mymvpdemo.fragment.FragmentOne;
import com.test.mymvpdemo.fragment.FragmentThree;
import com.test.mymvpdemo.fragment.FragmentTwo;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements
        ViewPager.OnPageChangeListener,
        BottomNavigationView.OnNavigationItemSelectedListener {

    @BindView(R.id.main_pager)
    ViewPager pager;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    @Override
    protected int layoutRes() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(FragmentOne.newInstance());
        fragmentList.add(FragmentTwo.newInstance());
        fragmentList.add(FragmentThree.newInstance());
        MainFragmentAdapter adapter = new MainFragmentAdapter(getSupportFragmentManager(), fragmentList);
        pager.setOffscreenPageLimit(3);
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(this);
        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        menuItem.setChecked(true);
        switch (menuItem.getItemId()) {
            case R.id.main_item_one:
                pager.setCurrentItem(0,false);
                break;
            case R.id.main_item_two:
                pager.setCurrentItem(1,false);
                break;
            case R.id.main_item_three:
                pager.setCurrentItem(2,false);
                break;
            default:
                break;
        }
        return false;
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        switch (i) {
            case 0:
                navigation.setSelectedItemId(R.id.main_item_one);
                break;
            case 1:
                navigation.setSelectedItemId(R.id.main_item_two);
                break;
            case 2:
                navigation.setSelectedItemId(R.id.main_item_three);
                break;
            default:
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
