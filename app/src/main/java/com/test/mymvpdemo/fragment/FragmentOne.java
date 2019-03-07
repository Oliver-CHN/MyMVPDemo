package com.test.mymvpdemo.fragment;

import android.content.Context;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.test.mymvpdemo.R;
import com.test.mymvpdemo.adapter.MainFragmentAdapter;
import com.test.mymvpdemo.base.BaseFragment;
import com.test.mymvpdemo.base.NetworkErrorCallback;
import com.test.mymvpdemo.bean.JournalismBean;
import com.test.mymvpdemo.mvp.DataView;
import com.test.mymvpdemo.mvp.novel.JournalismPresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FragmentOne extends BaseFragment implements DataView<JournalismBean>, TabLayout.OnTabSelectedListener {


    @BindView(R.id.vp_fragment_one)
    ViewPager viewPager;
    @BindView(R.id.tab_fragment_one)
    TabLayout tabLayout;

    private JournalismPresenter presenter = new JournalismPresenter();

    @Override
    protected int setContentView() {
        return R.layout.fragment_one;
    }

    @Override
    protected void init() {
        presenter.getData();
    }

    public static FragmentOne newInstance() {
        return new FragmentOne();
    }

    @Override
    public void showData(JournalismBean journalismBean) {
        loadService.showSuccess();
        String[] titles = {"tech", "auto", "money", "sports", "dy", "war", "ent", "toutiao"};
        List<Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(FragmentJournalism.newInstance(journalismBean.tech));
        fragmentList.add(FragmentJournalism.newInstance(journalismBean.auto));
        fragmentList.add(FragmentJournalism.newInstance(journalismBean.money));
        fragmentList.add(FragmentJournalism.newInstance(journalismBean.sports));
        fragmentList.add(FragmentJournalism.newInstance(journalismBean.dy));
        fragmentList.add(FragmentJournalism.newInstance(journalismBean.war));
        fragmentList.add(FragmentJournalism.newInstance(journalismBean.ent));
        fragmentList.add(FragmentJournalism.newInstance(journalismBean.toutiao));
        MainFragmentAdapter adapter = new MainFragmentAdapter(getFragmentManager(), fragmentList, titles);
        viewPager.setOffscreenPageLimit(8);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.addOnTabSelectedListener(this);
    }

    @Override
    public void showFailureMessage(String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showErrorMessage(String msg) {
        loadService.showCallback(NetworkErrorCallback.class);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        presenter.attachView(this);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        presenter.detachView();
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition(),false);
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
