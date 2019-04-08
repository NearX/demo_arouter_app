package com.ybkj.base.common;

/**
 * Description 参数配置
 * Author Ren Xingzhi
 * Created on 2019/1/2.
 * Email 15384030400@163.com
 */
public class Constants {
    public static final String BUGLY_APP_ID = "b11f3d68e0";
    public static final String TOKEN_SAVE_KEY = "token";
    public static final String PROJECT = "demo";

    public static final String PORT = "app/";

    //测试服务器
//    public static final String DEFAULT_BASE_URL = "http://192.168.4.103:18083";
//    public static final String DEFAULT_BASE_URL_SELL = "http://192.168.4.103:18082";

    //登录界面的账号保存的key
    public static final String LOGIN_NAME_KEY = "login_key";

    //intent请求公共key
    public static final String INTENT_PARAMETER_1 = "intent_parameter_1";
    public static final String INTENT_PARAMETER_2 = "intent_parameter_2";
    public static final String INTENT_PARAMETER_3 = "intent_parameter_3";
    public static final String INTENT_PARAMETER_4 = "intent_parameter_4";

    //连接超时时间
    public static final int connectionTime = 10;

    public static final int PAGE_NUM = 20;

    //请求标记码
    public static final int REQUEST_CODE_1 = 101;
    public static final int REQUEST_CODE_2 = 102;
    public static final int REQUEST_CODE_3 = 103;
    public static final int REQUEST_CODE_4 = 104;
    public static final int REQUEST_CODE_5 = 105;

    //标记通用
    public static final int TAG_NORMAL_1 = 111;
    public static final int TAG_NORMAL_2 = 112;
    public static final int TAG_NORMAL_3 = 113;

    public static final String SOPHIX_APPKEY = "25605841";
    public static final String SOPHIX_APPSECRET = "ba4262d35a72676a461d52fda08bf869";
    public static final String SOPHIX_REA_KEY = "MIIEvAIBADANBgkqhkiG9w0BAQEFAASCBKYwggSiAgEAAoIBAQCHUXrt2Efn3FpShNK/0SEPvV+2qscwjl7zNHx20NlikaItbkQvUeCqB7LpgXQtImyWyRBRETjjXdObkvI7h" +
            "/fye/8ZUlZJoYqpZOk9nLKS0mftzwKFfdu7iGF30PCdxxPO1iBsvCHB0S9x2Kib8E7OBFpcvAEBgH+3BN1Q2" +
            "05CLL8vkKbawdNE5Fx0e2AgMWhRiAOTsRAaCk7OdzFd1A/lc8fYn1VCpjTfhjRmhCSHvryR3IiC9tTAhffjNE7" +
            "5k9+ExewaELC+o47cqDC2hMDWZOJxTGXjT/jBahWu2KmaFjSyUQj8hZKGfkHVsQLjWoIuS3zj/VsSYJWboNfKX" +
            "TAPAgMBAAECggEAJjTTSKRwaP7GYdYuywn5E8Ccba76XrNUC8cd/U4qkrIb4Efp6JJtpJRX56YtbzDxCAHtIXaD" +
            "YW70eFCdJEHXuBdah4O/6To7NGjRkhvUL7BIt9RjGd3XVLPFEVdlGKdE6Hl83jagMWEmzDYoJR9MoM6J1PUgM5R" +
            "cewhclJ/XEMe3ID6N7nKmCudy90XaElQ1PYI9MPZG3Hx5IWoUCx7+5+8BvfJWqqYXS/Py6p2s5iTxtqomKsYKl0E" +
            "10e1zp00zPrI9HUGV+wd7nddNVkYZqCQ/iJ3KofabdPCoNZbmTyi65a70+zYYTNCY1HIJUwGIMHy2cURNZFBiCG" +
            "95fcw/QQKBgQDaZ4EkevXhah0QOldheea3ParJZ77HDgWL+fFbeEzDWEhxKzj/E3/oQVljt77qAI9uOCHjbls/kU" +
            "fKXI80Iay2ujkpvDRBMQx0f6jrMSrZFDlxi7t1BdGi9bKr1TEODqam3UefchswnCb8hghW+DL838iS8hg8IpT/K" +
            "/WFgxGp9QKBgQCenJiOCXWNnQ3wtqSVuT3b4vOMB5iG/SQ6D3heLlAnKCYAuNqYohQ7Ut5cDBB/NOzKQsPgARHv" +
            "UIEt0Ih49xpB+NkvgL4s+KbWjeB1enUFxtjhDsaTO/76xMwmXESbWaTDFzJv7hg10zJWLN23sQItgq8W6I9dBNri" +
            "WbvlhN0bcwKBgCqdz8FCjP/zKMCl4a8PjklrKwwpxjwpLEPn/YSPsMrdSyVp/bEoKOk09zBSBlq6yUIEifhK7Fs3" +
            "Cf8emILfn0f4hnbyVm/yFjAVSOy7p1S8cYkKbwWioQlfUAHfk7befP5KZ1NhfJS7o4/ax33Q6IIXWJfzzW7OgKxZ84" +
            "qdzLCRAoGABZpMfT/yShVRJ76b47oOaFUE+15NUf9hJzfirZj/NdLiPMZK2ndnNY1A04mNj6DD+IURPDltc8GpPoA" +
            "OQg+getIageYPUbFa21tZoWy484JJqPGHrC3DXQJUn8pEliQ9gLKyEmgbrNMQBSFCl7mF9SuXmbyPS97fCH3Y+EuQL" +
            "+cCgYAyocO9jFjJq5PBAvL70y3MMBVqAc1cvD0V9GgQ7mAUJqzaVAt7cC0Sg5MlCcMxztLPZIVaDj4X9B1yCqyO9hq" +
            "IqYhYHDWK+RGNLymgFPVtNm9mNEgkZH6e+klZC4MLbIz0AXVDOoxxNweagfjjJS2RzeDdmnih0e1f+IOhAfjzpg==";


    public static final String APPEALID = "appealId";

    //帮助中心
    //  public static final String HELP_CENTER_DETAIL_H5 = DEFAULT_BASE_URL_SELL + "/saleApp/systemHelp/systemHelpDetails/";


}
