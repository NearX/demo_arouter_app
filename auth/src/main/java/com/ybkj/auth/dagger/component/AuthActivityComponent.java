package com.ybkj.auth.dagger.component;

import android.app.Activity;
import android.content.Context;

import com.ybkj.auth.dagger.module.AuthHttpModule;
import com.ybkj.auth.network.AuthApiService;
import com.ybkj.auth.page.activity.LoginActivity;
import com.ybkj.base.dagger.component.AppComponent;
import com.ybkj.base.dagger.module.ActivityModule;
import com.ybkj.base.dagger.scope.ActivityScope;

import dagger.Component;

/**
 * Description
 * Author Ren Xingzhi
 * Created on 2019/3/26.
 * Email 15384030400@163.com
 */
@ActivityScope
@Component(dependencies = AppComponent.class, modules = {ActivityModule.class, AuthHttpModule.class})
public interface AuthActivityComponent {
    Activity getActivity();

    Context getContext();

    AuthApiService getAuthApiService();

    void inject(LoginActivity loginActivity);

}
