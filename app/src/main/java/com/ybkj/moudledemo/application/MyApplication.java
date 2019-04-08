package com.ybkj.moudledemo.application;

import com.ybkj.base.BaseApplication;
import com.ybkj.base.BuildConfig;
import com.ybkj.moudledemo.common.AppConstants;

/**
 * Description
 * Author Ren Xingzhi
 * Created on 2019/3/27.
 * Email 15384030400@163.com
 */
public class MyApplication extends BaseApplication {

    @Override
    public String getServerAddress() {
        return "http://192.168.4.103:18083";
    }

    @Override
    public String getTokenKey() {
        return AppConstants.TOKEN_KEY;
    }

    @Override
    public String getBuglyId() {
        return AppConstants.BUGLY_ID;
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }
}
