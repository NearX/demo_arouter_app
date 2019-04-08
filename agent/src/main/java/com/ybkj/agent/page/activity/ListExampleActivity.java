package com.ybkj.agent.page.activity;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ybkj.agent.R;
import com.ybkj.agent.R2;
import com.ybkj.agent.adapter.ListAdapter;
import com.ybkj.agent.bean.ExampleData;
import com.ybkj.agent.dagger.component.DaggerAgentActivityComponent;
import com.ybkj.agent.page.presenter.ListExamplePresenter;
import com.ybkj.agent.page.view.IListExampleView;
import com.ybkj.base.BaseApplication;
import com.ybkj.base.dagger.module.ActivityModule;
import com.ybkj.base.ui.view.recyclerview.XRecyclerView;
import com.ybkj.project_base.base.BaseMvpActivity;
import com.ybkj.project_base.router.AgentPath;
import com.ybkj.project_base.ui.view.MyActionBar;
import com.ybkj.project_base.ui.view.refreshlayout.XRefreshLayout;

import java.util.List;

import butterknife.BindView;

/**
 * Description
 * Author Ren Xingzhi
 * Created on 2019/3/31.
 * Email 15384030400@163.com
 */

@Route(path = AgentPath.PATH_LIST)
public class ListExampleActivity extends BaseMvpActivity<ListExamplePresenter> implements IListExampleView {


    @BindView(R2.id.action_bar)
    MyActionBar actionBar;
    @BindView(R2.id.recycle_view)
    XRecyclerView recycleView;
    @BindView(R2.id.refresh_layout)
    XRefreshLayout refreshLayout;

    private ListAdapter adapter;

    @Override
    protected void injectPresenter() {
        DaggerAgentActivityComponent.builder()
                .appComponent(BaseApplication.getAppComponent())
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.agent_activity_list_example;
    }

    @Override
    protected void initView() {
        adapter = new ListAdapter(mContext);
        recycleView.setAdapter(adapter);
        refreshLayout.setOnRefreshListener(new XRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getData();
            }

            @Override
            public boolean checkCanDoRefresh(View content, View header) {
                return recycleView.isCanRefresh();
            }
        });

        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                presenter.getData();
            }
        }, recycleView);
    }

    @Override
    protected void initData() {
        presenter.getData();
    }

    @Override
    public void refreshData(List<ExampleData> data) {
        adapter.setNewData(data);
        refreshLayout.refreshComplete();
    }

    @Override
    public void loadMoreData(List<ExampleData> data) {
        adapter.addData(data);
        adapter.loadMoreComplete();
    }

    @Override
    public void showEmptyView() {
        adapter.getData().clear();
        showNetRecycleEmptyView(recycleView);
        refreshLayout.refreshComplete();
    }

    @Override
    public void loadMoreEnd() {
        adapter.loadMoreEnd(true);
    }

}
