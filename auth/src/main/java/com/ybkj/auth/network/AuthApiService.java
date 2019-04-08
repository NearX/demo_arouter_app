package com.ybkj.auth.network;

import com.ybkj.auth.bean.request.LoginReq;
import com.ybkj.base.bean.BaseResponse;
import com.ybkj.project_base.bean.LoginRes;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * - @Author:  Yi Shan Xiang
 * - @Description:  ApiService
 * - @Time:  2018/8/31
 * - @Emaill:  380948730@qq.com
 */
public interface AuthApiService {

    /**
     * 用户登录
     *
     * @param req 请求实体类
     * @return
     */
    @POST("/user/login")
    Observable<BaseResponse<LoginRes>> startLogin(@Body LoginReq req);

//    /**
//     * 找回密码
//     *
//     * @return
//     */
//    @POST("userApp/frogetPassword/froget")
//    Observable<BaseResponse<Object>> forgetPass(@Body ModifyPassReq modifyPassReq);
//
//    /**
//     * 修改默认密码
//     *
//     * @returna
//     */
//    @POST("userApp/resetPassword//updatePwd")
//    Observable<BaseResponse<Object>> modifyNormalPwd(@Body ModifyPassReq modifyPassReq);
//
//    /**
//     * 修改密码
//     *
//     * @return
//     */
//    @POST("userApp/myInfo/modifyPwd")
//    Observable<BaseResponse<MineDataRes>> modifyPsd(@Body ModifyReq req);
//
//    /**
//     * 获取验证码
//     */
//    @POST("sendCode/sendPhoneCode")
//    Observable<BaseResponse<Object>> getVerificationCode(@Body ModifyReq req);
//
//    /**
//     * 修改手机号码
//     *
//     * @param req
//     * @return
//     */
//    @POST("userApp/myInfo/modifyPhone")
//    Observable<BaseResponse<Object>> modifyPhone(@Body ModifyReq req);
//
//    /**
//     * 修改账号
//     *
//     * @param
//     * @return
//     */
//    @POST("userApp/myInfo/modifyUserAccount")
//    Observable<BaseResponse<Object>> modifyAccount(@Body ModifyReq req);


}
