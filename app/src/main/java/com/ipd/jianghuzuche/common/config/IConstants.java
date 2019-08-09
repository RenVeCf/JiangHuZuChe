package com.ipd.jianghuzuche.common.config;

/**
 * Description ：公共配置类
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2018/8/26.
 */
public interface IConstants {
    /**
     * 包名
     */
    String PACKAGE_NAME = "com.ipd.jianghuzuche";

    /**
     * SharedPreferences
     * 共享参数
     */
    String FIRST_APP = "is_first"; //第一次进应用
    String IS_LOGIN = "is_login"; //已经登录
    String IS_SUPPLEMENT_INFO = "is_supplement_info"; //已经认证
    String USER_ID = "user_id"; //用户标识
    String NAME = "name"; //用户真实姓名
    String PHONE = "phone"; //用户手机号码
    String SERVICE_PHONE = "service_phone"; //咨询客服号码
    String AVATAR = "avatar"; //头像
    String REVIEW = "review"; //1.未上传资料 2正常4.审核中 5.已拒绝
    String INVITAION_CODE = "invitation_code"; //邀请码
    String LATIUDE = "latitude"; //经度
    String LONGTITUDE = "longtitude"; //纬度
    String CITY = "city"; //城市
    int JPUSH_SEQUENCE = 100; //极光精准推送序列
    //------------非公用共享参数（仅为传值方便）------------------
    String STORE_ID = "storeId"; //门店id
    String STORE_NAME = "StoreName"; //门店名称
    String STORE_PATH = "StorePath"; //门店地址
    String USE_CAR_TIME = "UseCarTime"; //租赁时长


    /**
     * requestCode
     * 请求码
     */
    int REQUEST_CODE_90 = 90;
    int REQUEST_CODE_91 = 91;
    int REQUEST_CODE_92 = 92;
    int REQUEST_CODE_93 = 93;
    int REQUEST_CODE_94 = 94;
    int REQUEST_CODE_95 = 95;
    int REQUEST_CODE_96 = 96;
    int REQUEST_CODE_97 = 97;
    int REQUEST_CODE_98 = 98;
    int REQUEST_CODE_99 = 99;
    int REQUEST_CODE_100 = 100;
    int REQUEST_CODE_101 = 101;
    int REQUEST_CODE_102 = 102;
    int REQUEST_CODE_103 = 103;
    int REQUEST_CODE_104 = 104;
    int REQUEST_CODE_105 = 105;

    /**
     * resultCode
     * 返回码
     */
    int RESULT_CODE = 0;
}
