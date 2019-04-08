package com.ybkj.auth.bean.request;

/**
 * Description
 * Author Ren Xingzhi
 * Created on 2019/3/28.
 * Email 15384030400@163.com
 */
public class LoginReq {
    private String account;
    private String password;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
