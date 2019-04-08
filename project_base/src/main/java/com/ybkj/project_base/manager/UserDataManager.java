package com.ybkj.project_base.manager;


import com.ybkj.base.common.Constants;
import com.ybkj.base.utils.SPHelper;
import com.ybkj.base.utils.preferences.PreferencesUtils;
import com.ybkj.project_base.bean.LoginRes;

/**
 * - @Author:  Yi Shan Xiang
 * - @Description:  用户信息管理
 * - @Time:  2018/8/31
 * - @Emaill:  380948730@qq.com
 */
public class UserDataManager {
    private static String KEY_USER_INFO = "login_info";

    /**
     * Save getCompanyList info.
     *
     * @param loginRes the getCompanyList res
     */
    public static void saveLoginInfo(LoginRes loginRes) {
        PreferencesUtils.saveObject(KEY_USER_INFO, loginRes);
        SPHelper.getInstance().set(Constants.TOKEN_SAVE_KEY, loginRes.getToken());
    }

    /**
     * Gets getCompanyList info.
     *
     * @return the getCompanyList info
     */
    public static LoginRes getLoginInfo() {
        return (LoginRes) PreferencesUtils.getObject(KEY_USER_INFO, null);
    }

    /**
     * Gets token.
     *
     * @return the token
     */
    public static String getToken() {
        LoginRes loginInfo = getLoginInfo();
        if (loginInfo != null) {
            return loginInfo.getToken();
        }
        return null;
    }

    public static void clearLoginInfo() {
        saveLoginInfo(null);
    }
}
