package com.ybkj.agent.page.presenter;

import android.content.Context;

import com.ybkj.agent.bean.ExampleData;
import com.ybkj.agent.page.view.IListExampleView;
import com.ybkj.base.base.BaseRxPresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

/**
 * Description
 * Author Ren Xingzhi
 * Created on 2019/3/31.
 * Email 15384030400@163.com
 */
public class ListExamplePresenter extends BaseRxPresenter<IListExampleView> {

    @Inject
    public ListExamplePresenter(Context context) {
        super(context);
    }

    @Override
    public void onSuccess(Object response, int tag) {
        List<ExampleData> datas = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            ExampleData data = new ExampleData();
            data.setId(i);
            data.setName("Item" + i + 1);
            data.setImage("https://tva1.sinaimg.cn/crop.0.0.800.800.180/0060LZgfjw8fbus95bgx1j30m80m8whu.jpg");
            datas.add(data);
        }
        mView.refreshData(datas);
    }

    public void getData() {
        onSuccess(null, 0);
    }
}
