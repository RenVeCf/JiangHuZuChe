package com.ipd.jianghuzuche.api;

import com.ipd.jianghuzuche.bean.AddBankBean;
import com.ipd.jianghuzuche.bean.AliPayBean;
import com.ipd.jianghuzuche.bean.CancelOrderBean;
import com.ipd.jianghuzuche.bean.CaptchaBean;
import com.ipd.jianghuzuche.bean.CarReturnConfirmBean;
import com.ipd.jianghuzuche.bean.CarReturnDetailsBean;
import com.ipd.jianghuzuche.bean.CashWithdrawalBean;
import com.ipd.jianghuzuche.bean.CashWithdrawalFeeBean;
import com.ipd.jianghuzuche.bean.ChargeBean;
import com.ipd.jianghuzuche.bean.ChoiceStoreBean;
import com.ipd.jianghuzuche.bean.ConfirmVehicleBean;
import com.ipd.jianghuzuche.bean.CouponBean;
import com.ipd.jianghuzuche.bean.ExtendTimeBean;
import com.ipd.jianghuzuche.bean.ExtendTimeListBean;
import com.ipd.jianghuzuche.bean.FeedBackBean;
import com.ipd.jianghuzuche.bean.ForgetPwdBean;
import com.ipd.jianghuzuche.bean.GetCarBean;
import com.ipd.jianghuzuche.bean.HomeBean;
import com.ipd.jianghuzuche.bean.LastBankBean;
import com.ipd.jianghuzuche.bean.LoginBean;
import com.ipd.jianghuzuche.bean.ModifyUserDataBean;
import com.ipd.jianghuzuche.bean.MsgBean;
import com.ipd.jianghuzuche.bean.OrderDetailsBean;
import com.ipd.jianghuzuche.bean.RegisterBean;
import com.ipd.jianghuzuche.bean.RepairConfirmBean;
import com.ipd.jianghuzuche.bean.RepairDetailsBean;
import com.ipd.jianghuzuche.bean.RepairListBean;
import com.ipd.jianghuzuche.bean.RepairOrderBean;
import com.ipd.jianghuzuche.bean.RepairProjectHorizontalBean;
import com.ipd.jianghuzuche.bean.RepairProjectVerticalBean;
import com.ipd.jianghuzuche.bean.SelectBankBean;
import com.ipd.jianghuzuche.bean.SelectOpeningBankBean;
import com.ipd.jianghuzuche.bean.SelectOrderTypeBean;
import com.ipd.jianghuzuche.bean.SelectVehicleBean;
import com.ipd.jianghuzuche.bean.SupplementInfoBean;
import com.ipd.jianghuzuche.bean.UploadImgBean;
import com.ipd.jianghuzuche.bean.UserSelectCarBean;
import com.ipd.jianghuzuche.bean.WalletDetailsBean;
import com.ipd.jianghuzuche.bean.WeChatPayBean;
import com.ipd.jianghuzuche.common.config.UrlConfig;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

/**
 * Description ：请求配置
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2018/8/27.
 */
public interface ApiService {


    //轮播图
    @POST(UrlConfig.HOME)
    Observable<HomeBean> getHome();

    //用户端-根据位置选择门店
    @FormUrlEncoded
    @POST(UrlConfig.CHOICE_STORE)
    Observable<ChoiceStoreBean> getChoiceStore(@FieldMap Map<String, String> map);

    //用户端-门店查询-模糊查询
    @FormUrlEncoded
    @POST(UrlConfig.SEARCH_CHOICE_STORE)
    Observable<ChoiceStoreBean> getSearchChoiceStore(@FieldMap Map<String, String> map);

    //验证码
    @FormUrlEncoded
    @POST(UrlConfig.VERIFICATION_CODE)
    Observable<CaptchaBean> getCaptcha(@FieldMap Map<String, String> map);

    //忘记密码
    @FormUrlEncoded
    @POST(UrlConfig.FORGET_PWD)
    Observable<ForgetPwdBean> getForgetPwd(@FieldMap Map<String, String> map);


    //登录
    @FormUrlEncoded
    @POST(UrlConfig.LOGIN)
    Observable<LoginBean> getLogin(@FieldMap Map<String, String> map);

    //注册
    @FormUrlEncoded
    @POST(UrlConfig.REGISTER)
    Observable<RegisterBean> getRegister(@FieldMap Map<String, String> map);

    //上传身份证照片
    @FormUrlEncoded
    @POST(UrlConfig.UPLOAD_ID_IMG)
    Observable<SupplementInfoBean> getSupplementInfo(@FieldMap Map<String, String> map);

    //上传图片
    @Multipart
    @POST(UrlConfig.UPLOAD_IMG)
    Observable<UploadImgBean> getUploadImg(@Query("type") String description, @PartMap Map<String, RequestBody> map);

    //用户端-点击选车
    @FormUrlEncoded
    @POST(UrlConfig.SELECT_CAR)
    Observable<UserSelectCarBean> getUserSelectCar(@FieldMap Map<String, String> map);

    //我的优惠卷
    @FormUrlEncoded
    @POST(UrlConfig.COUPON)
    Observable<CouponBean> getCoupon(@FieldMap Map<String, String> map);

    //用户端-选车-支付宝支付
    @FormUrlEncoded
    @POST(UrlConfig.ALI_PAY)
    Observable<AliPayBean> getOrderAliPay(@FieldMap Map<String, String> map);

    //用户端-选车-微信支付
    @FormUrlEncoded
    @POST(UrlConfig.WEIXIN_PAY)
    Observable<WeChatPayBean> getOrderWeiXinPay(@FieldMap Map<String, String> map);

    //修改用户信息
    @FormUrlEncoded
    @POST(UrlConfig.MODIFY_USER_DATA)
    Observable<ModifyUserDataBean> getModifyUserData(@FieldMap Map<String, String> map);

    //维修保养-首页
    @FormUrlEncoded
    @POST(UrlConfig.REPAIR_LIST)
    Observable<RepairListBean> getRepairList(@FieldMap Map<String, String> map);

    //意见反馈
    @FormUrlEncoded
    @POST(UrlConfig.FEED_BACK)
    Observable<FeedBackBean> getFeedBack(@FieldMap Map<String, String> map);

    //订单查看-列表数据
    @FormUrlEncoded
    @POST(UrlConfig.SELECT_ORDER_ALL)
    Observable<SelectOrderTypeBean> getSelectOrderType(@FieldMap Map<String, String> map);

    //订单查看-详情
    @FormUrlEncoded
    @POST(UrlConfig.ORDER_DETAILS)
    Observable<OrderDetailsBean> getOrderDetails(@FieldMap Map<String, String> map);

    //订单-待付款-取消订单
    @FormUrlEncoded
    @POST(UrlConfig.CANCEL_ORDER)
    Observable<CancelOrderBean> getUnpaidCancelOrder(@FieldMap Map<String, String> map);

    //订单-取车-取消订单
    @FormUrlEncoded
    @POST(UrlConfig.GET_CAR_CANCEL_ORDER)
    Observable<CancelOrderBean> getGetCarCancelOrder(@FieldMap Map<String, String> map);

    //订单查看-详情-查看车辆
    @FormUrlEncoded
    @POST(UrlConfig.SELECT_VEHICLE)
    Observable<SelectVehicleBean> getSelectVehicle(@FieldMap Map<String, String> map);

    //订单查看-详情-确认取车
    @FormUrlEncoded
    @POST(UrlConfig.GET_CAR)
    Observable<GetCarBean> getGetCar(@FieldMap Map<String, String> map);

    //查看退车单
    @FormUrlEncoded
    @POST(UrlConfig.CAR_RETURN_DETAILS)
    Observable<CarReturnDetailsBean> getCarReturnDetails(@FieldMap Map<String, String> map);

    //订单-查看退车单-取消订单
    @FormUrlEncoded
    @POST(UrlConfig.CAR_RETURN_CANCEL_ORDER)
    Observable<CancelOrderBean> getCarReturnCancelOrder(@FieldMap Map<String, String> map);

    //提前还车-查看推车单-确认
    @FormUrlEncoded
    @POST(UrlConfig.CAR_RETURN_CONFIRM)
    Observable<CarReturnConfirmBean> getCarReturnConfirm(@FieldMap Map<String, String> map);

    //我的钱包余额明细
    @FormUrlEncoded
    @POST(UrlConfig.WALLET)
    Observable<WalletDetailsBean> getWalletDetails(@FieldMap Map<String, String> map);

    //提现费率
    @FormUrlEncoded
    @POST(UrlConfig.CASH_WITHDRAWAL_FEE)
    Observable<CashWithdrawalFeeBean> getCashWithdrawalFee(@FieldMap Map<String, String> map);

    //我的银行卡列表
    @FormUrlEncoded
    @POST(UrlConfig.SELECT_BACK)
    Observable<SelectBankBean> getSelectBank(@FieldMap Map<String, String> map);

    //添加银行卡-选择开户行
    @POST(UrlConfig.SELECT_OPENING_BACK)
    Observable<SelectOpeningBankBean> getSelectOpeningBank();

    //添加银行卡
    @FormUrlEncoded
    @POST(UrlConfig.ADD_BANK)
    Observable<AddBankBean> getAddBank(@FieldMap Map<String, String> map);

    //我的银行卡最近使用的-一张银行卡
    @FormUrlEncoded
    @POST(UrlConfig.LAST_BANK)
    Observable<LastBankBean> getLastBank(@FieldMap Map<String, String> map);

    //我的钱包提现
    @FormUrlEncoded
    @POST(UrlConfig.CASH_WITHDRAWAL)
    Observable<CashWithdrawalBean> getCashWithdrawal(@FieldMap Map<String, String> map);

    //维修订单-列表
    @FormUrlEncoded
    @POST(UrlConfig.REPAIR_ORDER)
    Observable<RepairOrderBean> getRepairOrder(@FieldMap Map<String, String> map);

    //维修订单-列表-详情
    @FormUrlEncoded
    @POST(UrlConfig.REPAIR_DETAILS)
    Observable<RepairDetailsBean> getRepairDetails(@FieldMap Map<String, String> map);

    //维修保养-维修项目-类型
    @FormUrlEncoded
    @POST(UrlConfig.REPAIR_PROJECT_HORIZONTAL)
    Observable<RepairProjectHorizontalBean> getRepairProjectHorizontal(@FieldMap Map<String, String> map);

    //维修保养-类型列表数据
    @FormUrlEncoded
    @POST(UrlConfig.REPAIR_PROJECT_VERTICAL)
    Observable<RepairProjectVerticalBean> getRepairProjectVertical(@FieldMap Map<String, String> map);

    //维修保养-充电下拉数据
    @FormUrlEncoded
    @POST(UrlConfig.CHARGE)
    Observable<ChargeBean> getCharge(@FieldMap Map<String, String> map);

    //维修保养-确认下单
    @FormUrlEncoded
    @POST(UrlConfig.REPAIR_CONFIRM)
    Observable<RepairConfirmBean> getRepairConfirm(@FieldMap Map<String, String> map);

    //维修订单-支付包支付
    @FormUrlEncoded
    @POST(UrlConfig.REPAIR_ALI)
    Observable<AliPayBean> getRepairAli(@FieldMap Map<String, String> map);

    //维修订单-微信支付
    @FormUrlEncoded
    @POST(UrlConfig.REPAIR_WECHAT)
    Observable<WeChatPayBean> getRepairWeChat(@FieldMap Map<String, String> map);

    //提前还车-确认页面
    @FormUrlEncoded
    @POST(UrlConfig.CONFIRM_VEHICLE)
    Observable<ConfirmVehicleBean> getConfirmVehicle(@FieldMap Map<String, String> map);

    //延长租车-页面数据
    @FormUrlEncoded
    @POST(UrlConfig.EXTEND_TIME)
    Observable<ExtendTimeBean> getExtendTime(@FieldMap Map<String, String> map);

    //延长租车-租车服务--列表
    @FormUrlEncoded
    @POST(UrlConfig.EXTEND_TIME_LIST)
    Observable<ExtendTimeListBean> getExtendTimeList(@FieldMap Map<String, String> map);

    //延长租车-支付宝支付
    @FormUrlEncoded
    @POST(UrlConfig.EXTEND_TIME_ALI)
    Observable<AliPayBean> getExtendTimeAli(@FieldMap Map<String, String> map);

    //延长租车-微信支付
    @FormUrlEncoded
    @POST(UrlConfig.EXTEND_TIME_WECHAT)
    Observable<WeChatPayBean> getExtendTimeWeiChat(@FieldMap Map<String, String> map);

    //用户端-消息列表
    @FormUrlEncoded
    @POST(UrlConfig.MSG)
    Observable<MsgBean> getMsg(@FieldMap Map<String, String> map);

    //订单-查看车辆-取消订单
    @FormUrlEncoded
    @POST(UrlConfig.SELECT_CAR_CANCEL_ORDER)
    Observable<CancelOrderBean> getSelectCarCancelOrder(@FieldMap Map<String, String> map);

    //待付款--支付包支付
    @FormUrlEncoded
    @POST(UrlConfig.SELECT_PAY_ALI)
    Observable<AliPayBean> getSelectTypeAli(@FieldMap Map<String, String> map);

    //待付款--微信支付
    @FormUrlEncoded
    @POST(UrlConfig.SELECT_PAY_WECHAT)
    Observable<WeChatPayBean> getSelectTypeWeChat(@FieldMap Map<String, String> map);

//    //获取用户信息
//    @GET(UrlConfig.GET_USER_INFO)
//    Observable<UserInfoBean> getUserInfo();
//
//    //修改用户信息
//    @FormUrlEncoded
//    @PUT(UrlConfig.GET_USER_INFO)
//    Observable<ModifyPersonalDataBean> getModifyPersonalData(@FieldMap Map<String, String> map);
//
//    //获取用户成长值记录列表
//    @GET(UrlConfig.GROWTH_VALUE_LIST)
//    Observable<GrowthValueBean> getGrowthValueList(@QueryMap Map<String, String> map);
//
//    //获取券列表
//    @GET(UrlConfig.COUPON_LIST)
//    Observable<CouponListBean> getCouponList();
//
//    //券详情中立即使用按钮跳转的URL
//    @GET(UrlConfig.COUPON_DETAILS_BT_URL)
//    Observable<CouponDetailsBtUrlBean> getCouponDetailsBtUrl(@QueryMap Map<String, String> map);
//
//    //获取活动列表
//    @GET(UrlConfig.ACTIVITIES)
//    Observable<AcitvitiesBean> getActivities();


}
