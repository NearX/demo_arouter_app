package com.ybkj.moudledemo;

import android.view.View;

import com.alibaba.android.arouter.launcher.ARouter;
import com.ybkj.project_base.base.BaseMvpActivity;
import com.ybkj.project_base.router.AuthPath;

public class MainActivity extends BaseMvpActivity {

    @Override
    protected void injectPresenter() {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        findViewById(R.id.btn_login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(AuthPath.PATH_LOGIN)
                        .navigation();
            }
        });
    }

    @Override
    protected void initData() {

    }

}
