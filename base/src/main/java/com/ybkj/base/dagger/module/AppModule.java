package com.ybkj.base.dagger.module;


import com.ybkj.base.BaseApplication;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * - @Author:  Yi Shan Xiang
 * - @Description:  提供全局application的对象，通过注解生成
 * 注意此处为有参构造函数，所以需要在构建Component的时候手动调用添加
 * <p>
 * - @Time:  2018/9/5
 * - @Emaill:  380948730@qq.com
 */
@Module
public class AppModule {
    private BaseApplication baseApplication;

    public AppModule(BaseApplication baseApplication) {
        this.baseApplication = baseApplication;
    }

    @Provides
    @Singleton
    BaseApplication provideMyApplication() {
        return baseApplication;
    }

    @Named("serverAddress")
    @Provides
    @Singleton
    String provideServerAddress() {
        return baseApplication.getServerAddress();
    }

    @Named("tokenKey")
    @Provides
    @Singleton
    String provideTokenKey() {
        return baseApplication.getTokenKey();
    }
}
