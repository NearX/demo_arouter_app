package com.ybkj.auth.page.presenter;

import android.content.Context;

import com.ybkj.auth.bean.request.LoginReq;
import com.ybkj.auth.network.AuthApiService;
import com.ybkj.auth.page.view.ILoginView;
import com.ybkj.base.base.BaseRxPresenter;
import com.ybkj.base.common.Constants;
import com.ybkj.base.net.exception.HandlerException;

import javax.inject.Inject;

/**
 * Description
 * Author Ren Xingzhi
 * Created on 2019/3/26.
 * Email 15384030400@163.com
 */
public class LoginPresenter extends BaseRxPresenter<ILoginView> {

    @Inject
    AuthApiService authApiService;

    @Inject
    public LoginPresenter(Context context) {
        super(context);
    }


    @Override
    public void onSuccess(Object response, int tag) {

    }

    @Override
    public void onError(HandlerException.ResponseThrowable e, int tag) {
        super.onError(e, tag);
        mView.loginSuccess();
    }

    public void login() {
        LoginReq loginReq = new LoginReq();
        loginReq.setAccount("1233333333");
        loginReq.setPassword("000123");
        sendHttpRequest(authApiService.startLogin(loginReq), Constants.REQUEST_CODE_1);
    }
}
