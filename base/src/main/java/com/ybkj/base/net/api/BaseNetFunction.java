package com.ybkj.base.net.api;


import com.ybkj.base.bean.BaseResponse;
import com.ybkj.base.common.NetResponseCode;
import com.ybkj.base.net.exception.HandlerException;
import com.ybkj.base.utils.LogUtil;

import io.reactivex.functions.Function;


/**
 * - @Author:  Yi Shan Xiang
 * - @Description:  网络请求请求返回结果的过滤
 * - @Time:  2018/8/31
 * - @Emaill:  380948730@qq.com
 */
public class BaseNetFunction<T> implements Function<BaseResponse<T>, T> {
    public BaseNetFunction() {
    }

    @Override
    public T apply(BaseResponse<T> resultEntry) throws Exception {

        int responseCode = resultEntry.getCode();
        String responseMessage = resultEntry.getMessage();
        T data = resultEntry.getData();
        switch (responseCode) {
            case NetResponseCode.HMC_SUCCESS:
                LogUtil.i(data == null ? "null" : "请求成功");
                if (data == null) {
                    throw new HandlerException.ResponseThrowable(responseMessage, NetResponseCode.HMC_SUCCESS_NULL);
                }
                return data;
            //其他情况自己处理
            default:
                throw new HandlerException.ResponseThrowable(responseMessage, responseCode, data);
        }
    }
}
