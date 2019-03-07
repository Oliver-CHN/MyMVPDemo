package com.test.mymvpdemo.fragment;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.test.mymvpdemo.R;
import com.test.mymvpdemo.adapter.ImageAdapter;
import com.test.mymvpdemo.base.BaseFragment;
import com.test.mymvpdemo.base.NetworkErrorCallback;
import com.test.mymvpdemo.bean.ImageBean;
import com.test.mymvpdemo.mvp.DataView;
import com.test.mymvpdemo.mvp.novel.ImagePresenter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class FragmentThree extends BaseFragment implements DataView<List<ImageBean>> {

    @BindView(R.id.rv_layout)
    RecyclerView recyclerView;

    private ImageAdapter adapter;

    private List<ImageBean> listData = new ArrayList<>();

    private ImagePresenter presenter = new ImagePresenter();

    @Override
    protected int setContentView() {
        return R.layout.layout_rv;
    }

    @Override
    protected void init() {
        recyclerView.setLayoutManager(new LinearLayoutManager(activity));
        adapter = new ImageAdapter(activity, listData);
        recyclerView.setAdapter(adapter);
        // 数据
        presenter.getData();
    }

    public static FragmentThree newInstance() {
        return new FragmentThree();
    }

    @Override
    public void showData(List<ImageBean> novelBeans) {
        loadService.showSuccess();
        if (listData != null) {
            listData.clear();
            listData.addAll(novelBeans);
        }
        adapter.notifyDataSetChanged();
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

}
