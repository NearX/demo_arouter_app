package com.ybkj.agent.page.view;

import com.ybkj.agent.bean.ExampleData;
import com.ybkj.base.base.BaseView;

import java.util.List;

/**
 * Description
 * Author Ren Xingzhi
 * Created on 2019/3/31.
 * Email 15384030400@163.com
 */
public interface IListExampleView extends BaseView {

    void refreshData(List<ExampleData> data);

    void loadMoreData(List<ExampleData> data);

    void showEmptyView();

    void loadMoreEnd();
}
