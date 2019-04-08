package com.ybkj.auth.page.activity;

import android.widget.Button;
import android.widget.EditText;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.ybkj.auth.R;
import com.ybkj.auth.R2;
import com.ybkj.auth.dagger.component.DaggerAuthActivityComponent;
import com.ybkj.auth.page.presenter.LoginPresenter;
import com.ybkj.auth.page.view.ILoginView;
import com.ybkj.base.BaseApplication;
import com.ybkj.base.dagger.module.ActivityModule;
import com.ybkj.project_base.base.BaseMvpActivity;
import com.ybkj.project_base.router.AgentPath;
import com.ybkj.project_base.router.AuthPath;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Description
 * Author Ren Xingzhi
 * Created on 2019/3/1.
 * Email 15384030400@163.com
 */
@Route(path = AuthPath.PATH_LOGIN)
public class LoginActivity extends BaseMvpActivity<LoginPresenter> implements ILoginView {


    @BindView(R2.id.edit_account)
    EditText editAccount;
    @BindView(R2.id.edit_password)
    EditText editPassword;
    @BindView(R2.id.btn_login)
    Button btnLogin;

    @Override
    protected void injectPresenter() {
        DaggerAuthActivityComponent.builder()
                .appComponent(BaseApplication.getAppComponent())
                .activityModule(new ActivityModule(this))
                .build()
                .inject(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_auth_login;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
    }


    @OnClick(R2.id.btn_login)
    public void onViewClicked() {
        presenter.login();

    }

    @Override
    public void loginSuccess() {
        ARouter.getInstance().build(AgentPath.PATH_LIST)
                .navigation();
    }
}
