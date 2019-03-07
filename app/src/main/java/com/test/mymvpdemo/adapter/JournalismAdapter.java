package com.test.mymvpdemo.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.test.mymvpdemo.fragment.FragmentJournalism;

import java.util.List;

public class JournalismAdapter extends FragmentPagerAdapter {

    private List<FragmentJournalism> fragmentList;
    private String[] titles;

    public JournalismAdapter(FragmentManager fm, List<FragmentJournalism> fragmentList) {
        super(fm);
        this.fragmentList = fragmentList;
    }

    public JournalismAdapter(FragmentManager fm, List<FragmentJournalism> fragmentList, String[] titles) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titles = titles;
    }

    @Override
    public Fragment getItem(int i) {
        return fragmentList.get(i);
    }

    @Override
    public int getCount() {
        return fragmentList == null ? 0 : fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if (titles != null && titles.length > 0) {
            return titles[position];
        } else {
            return "";
        }
    }
}
