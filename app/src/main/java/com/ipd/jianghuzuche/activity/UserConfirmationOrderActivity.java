package com.ipd.jianghuzuche.activity;

import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.mapapi.model.LatLng;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.aliPay.AliPay;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.AliPayBean;
import com.ipd.jianghuzuche.bean.UserSelectCarBean;
import com.ipd.jianghuzuche.bean.WeChatPayBean;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.OrderPayContract;
import com.ipd.jianghuzuche.presenter.OrderPayPresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.DateUtils;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.ToastUtil;
import com.ipd.jianghuzuche.utils.isClickUtil;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.Calendar;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.REQUEST_CODE_90;
import static com.ipd.jianghuzuche.common.config.IConstants.STORE_NAME;
import static com.ipd.jianghuzuche.common.config.IConstants.STORE_PATH;
import static com.ipd.jianghuzuche.common.config.IConstants.USER_ID;
import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_LOCAL_URL;
import static com.ipd.jianghuzuche.utils.ExchangeMapUtil.BD2GCJ;

/**
 * Description ：确认订单
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/4/30.
 */
public class UserConfirmationOrderActivity extends BaseActivity<OrderPayContract.View, OrderPayContract.Presenter> implements OrderPayContract.View {

    @BindView(R.id.tv_user_confirmation_order_top)
    TopView tvUserConfirmationOrderTop;
    @BindView(R.id.iv_user_confirmation_order)
    ImageView ivUserConfirmationOrder;
    @BindView(R.id.tv_user_confirmation_order_brand)
    TextView tvUserConfirmationOrderBrand;
    @BindView(R.id.tv_user_confirmation_order_introduce)
    TextView tvUserConfirmationOrderIntroduce;
    @BindView(R.id.tv_user_confirmation_order_go_choice_store)
    TextView tvUserConfirmationOrderGoChoiceStore;
    @BindView(R.id.tv_use_car_time)
    TextView tvUseCarTime;
    @BindView(R.id.tv_use_car_service_time)
    TextView tvUseCarServiceTime;
    @BindView(R.id.tv_use_car_service_charge)
    TextView tvUseCarServiceCharge;
    @BindView(R.id.tv_use_car_equipment_cost)
    TextView tvUseCarEquipmentCost;
    @BindView(R.id.tv_use_car_deposit)
    TextView tvUseCarDeposit;
    @BindView(R.id.tv_use_car_coupon_name)
    TextView tvUseCarCouponName;
    @BindView(R.id.tv_use_car_coupon_money)
    TextView tvUseCarCouponMoney;
    @BindView(R.id.tv_use_car_money_sum)
    TextView tvUseCarMoneySum;
    @BindView(R.id.tv_user_confirmation_order_coupon_type)
    TextView tvUserConfirmationOrderCouponType;
    @BindView(R.id.ll_user_confirmation_order_coupon)
    LinearLayout llUserConfirmationOrderCoupon;
    @BindView(R.id.cb_is_user_confirmation_order)
    CheckBox cbIsUserConfirmationOrder;
    @BindView(R.id.tv_user_confirmation_order_rule)
    TextView tvUserConfirmationOrderRule;
    @BindView(R.id.iv_alipay)
    ImageView ivAlipay;
    @BindView(R.id.ll_alipay)
    LinearLayout llAlipay;
    @BindView(R.id.iv_weixin_pay)
    ImageView ivWeixinPay;
    @BindView(R.id.ll_weixin_pay)
    LinearLayout llWeixinPay;
    @BindView(R.id.bt_user_confirmation_order)
    Button btUserConfirmationOrder;
    @BindView(R.id.tv_store_name)
    TextView tvStoreName;
    @BindView(R.id.tv_store_path)
    TextView tvStorePath;
    @BindView(R.id.tv_get_car_time)
    TextView tvGetCarTime;

    private UserSelectCarBean.DataBean.VehicleListBean userSelectCarBean = new UserSelectCarBean.DataBean.VehicleListBean();
    private UserSelectCarBean.DataBean.StoreByIdBean storeByIdBean = new UserSelectCarBean.DataBean.StoreByIdBean();
    private String coupon_name = "";
    private double coupon_money = 0;
    private int payType;
    private int couponId = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_user_confirmation_order;
    }

    @Override
    public OrderPayContract.Presenter createPresenter() {
        return new OrderPayPresenter(this);
    }

    @Override
    public OrderPayContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvUserConfirmationOrderTop);

        userSelectCarBean = getIntent().getParcelableExtra("car_details");
        storeByIdBean = getIntent().getParcelableExtra("store_by_id");
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + userSelectCarBean.getVehicleLogo()).apply(new RequestOptions().placeholder(R.mipmap.ic_launcher)).into(ivUserConfirmationOrder);
        tvUserConfirmationOrderBrand.setText(userSelectCarBean.getVehicleName());
        tvUserConfirmationOrderIntroduce.setText(userSelectCarBean.getVehicleModel());
        tvGetCarTime.setText(DateUtils.times2(Calendar.getInstance().getTimeInMillis()));
        tvUseCarEquipmentCost.setText(userSelectCarBean.getEquipCost() + "元");
        tvUseCarDeposit.setText(userSelectCarBean.getDeposit() + "元");
//        if (!SPUtil.get(this, USE_CAR_TIME, "").equals("")) {
//            if (userSelectCarBean.getRentOften() >= Integer.parseInt((String) SPUtil.get(this, USE_CAR_TIME, ""))) {
        tvUseCarTime.setText(userSelectCarBean.getRentOften() + "个月");
        tvUseCarServiceTime.setText(userSelectCarBean.getRentOften() + "x" + userSelectCarBean.getVehicleRent());
        tvUseCarServiceCharge.setText(userSelectCarBean.getRentOften() * userSelectCarBean.getVehicleRent() + "元");
//            } else {
//                tvUseCarTime.setText(SPUtil.get(this, USE_CAR_TIME, "") + "个月");
//                tvUseCarServiceTime.setText(SPUtil.get(this, USE_CAR_TIME, "") + "x" + userSelectCarBean.getVehicleRent());
//                tvUseCarServiceCharge.setText(Integer.parseInt((String) SPUtil.get(this, USE_CAR_TIME, "")) * userSelectCarBean.getVehicleRent() + "元");
//            }
//        }
        if (!SPUtil.get(this, STORE_NAME, "").equals(""))
            tvStoreName.setText(SPUtil.get(this, STORE_NAME, "") + "");
        if (!SPUtil.get(this, STORE_PATH, "").equals(""))
            tvStorePath.setText(SPUtil.get(this, STORE_PATH, "") + "");
        tvUseCarMoneySum.setText(Double.parseDouble(tvUseCarServiceCharge.getText().toString().trim().replaceAll("元", ""))
                + Double.parseDouble(tvUseCarEquipmentCost.getText().toString().trim().replaceAll("元", ""))
                + Double.parseDouble(tvUseCarDeposit.getText().toString().trim().replaceAll("元", "")) + "元");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (requestCode) {
                case REQUEST_CODE_90:
                    couponId = data.getIntExtra("coupon_id", 0);
                    coupon_name = data.getStringExtra("coupon_name");
                    tvUseCarCouponName.setText(coupon_name);
                    tvUserConfirmationOrderCouponType.setText(coupon_name);
                    coupon_money = data.getDoubleExtra("coupon_money", 0);
                    tvUseCarCouponMoney.setText("-" + coupon_money + "元");
                    double i = Double.parseDouble(tvUseCarServiceCharge.getText().toString().trim().replaceAll("元", ""))
                            + Double.parseDouble(tvUseCarEquipmentCost.getText().toString().trim().replaceAll("元", ""))
                            + Double.parseDouble(tvUseCarDeposit.getText().toString().trim().replaceAll("元", ""))
                            - coupon_money;
                    tvUseCarMoneySum.setText(i + "元");
                    break;
            }
        }
    }

    private void payType(int payType) {
        switch (payType) {
            case 0:
                TreeMap<String, String> aliPayMap = new TreeMap<>();
                aliPayMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
                aliPayMap.put("vehicleId", userSelectCarBean.getVehicleId() + "");
                aliPayMap.put("takevehicleTime", DateUtils.getTodayDateTime1());
                aliPayMap.put("rentDuration", tvUseCarTime.getText().toString().trim().replaceAll("个月", ""));
                aliPayMap.put("week", tvGetCarTime.getText().toString().substring(tvGetCarTime.getText().toString().length() - 2));
                aliPayMap.put("deposit", userSelectCarBean.getDeposit() + "");
                aliPayMap.put("equipCost", userSelectCarBean.getEquipCost() + "");
                aliPayMap.put("userCouponId", couponId + "");
                aliPayMap.put("tenancyService", tvUseCarServiceCharge.getText().toString().trim().replaceAll("元", ""));
                aliPayMap.put("total", tvUseCarMoneySum.getText().toString().trim().replaceAll("元", ""));
                getPresenter().getOrderAliPay(aliPayMap, true, false);
                break;
            case 1:
                TreeMap<String, String> weixinPayMap = new TreeMap<>();
                weixinPayMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
                weixinPayMap.put("vehicleId", userSelectCarBean.getVehicleId() + "");
                weixinPayMap.put("takevehicleTime", DateUtils.getTodayDateTime1());
                weixinPayMap.put("rentDuration", tvUseCarTime.getText().toString().trim().replaceAll("个月", ""));
                weixinPayMap.put("week", tvGetCarTime.getText().toString().substring(tvGetCarTime.getText().toString().length() - 2));
                weixinPayMap.put("deposit", userSelectCarBean.getDeposit() + "");
                weixinPayMap.put("equipCost", userSelectCarBean.getEquipCost() + "");
                weixinPayMap.put("userCouponId", couponId + "");
                weixinPayMap.put("tenancyService", tvUseCarServiceCharge.getText().toString().trim().replaceAll("元", ""));
                weixinPayMap.put("total", tvUseCarMoneySum.getText().toString().trim().replaceAll("元", ""));
                getPresenter().getOrderWeiXinPay(weixinPayMap, true, false);
                break;
        }
    }

    @OnClick({R.id.tv_user_confirmation_order_rule, R.id.tv_user_confirmation_order_go_choice_store, R.id.ll_user_confirmation_order_coupon, R.id.ll_alipay, R.id.ll_weixin_pay, R.id.bt_user_confirmation_order})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_user_confirmation_order_rule:
                startActivity(new Intent(this, WebViewActivity.class).putExtra("h5Type", 5));
                break;
            case R.id.tv_user_confirmation_order_go_choice_store:
                setMapDialog();
                break;
            case R.id.ll_user_confirmation_order_coupon:
                if (isClickUtil.isFastClick()) {
                    startActivityForResult(new Intent(this, UserCouponActivity.class).putExtra("money", Double.parseDouble(tvUseCarMoneySum.getText().toString().trim().replaceAll("元", ""))).putExtra("coupon_id", couponId), REQUEST_CODE_90);
                }
                break;
            case R.id.ll_alipay:
                payType = 0;
                ivAlipay.setVisibility(View.VISIBLE);
                ivWeixinPay.setVisibility(View.GONE);
                break;
            case R.id.ll_weixin_pay:
                payType = 1;
                ivAlipay.setVisibility(View.GONE);
                ivWeixinPay.setVisibility(View.VISIBLE);
                break;
            case R.id.bt_user_confirmation_order:
                if (isClickUtil.isFastClick()) {
                    if (cbIsUserConfirmationOrder.isChecked()) {
                        payType(payType);
                    } else
                        ToastUtil.showLongToast(R.string.error_check_box);
                }
                break;
        }
    }

    // 选择地图
    private void setMapDialog() {
        final Dialog mCameraDialog = new Dialog(this, R.style.BottomDialog);
        //Dialog布局
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(R.layout.dialog_map, null);
        root.findViewById(R.id.ll_baidu_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToBaiduMap(storeByIdBean.getDescAddress());
                mCameraDialog.dismiss();
            }
        });
        root.findViewById(R.id.ll_gaode_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToGaodeMap(storeByIdBean.getLatitude(), storeByIdBean.getLongitude(), storeByIdBean.getDescAddress());
                mCameraDialog.dismiss();
            }
        });
        root.findViewById(R.id.ll_tengxun_map).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToTengxunMap(storeByIdBean.getLatitude(), storeByIdBean.getLongitude(), storeByIdBean.getDescAddress());
                mCameraDialog.dismiss();
            }
        });
        mCameraDialog.setContentView(root);
        Window dialogWindow = mCameraDialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM); //设置弹出方式
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = 0; // 新位置Y坐标
        lp.width = (int) getResources().getDisplayMetrics().widthPixels; // 宽度
        root.measure(0, 0);
        lp.height = 500;

        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
        mCameraDialog.show();
    }

    /**
     * 跳转高德地图
     */
    private void goToGaodeMap(String lat, String lon, String descAddress) {
        if (!isInstalled("com.autonavi.minimap")) {
            ToastUtil.showShortToast("请先安装高德地图客户端");
            return;
        }
        LatLng endPoint = BD2GCJ(new LatLng(Double.parseDouble(lat), Double.parseDouble(lon)));//坐标转换
        StringBuffer stringBuffer = new StringBuffer("amapuri://openFeature?featureName=").append("OnRideNavi");
        stringBuffer.append("&rideType=").append("bike")
                .append("&sourceApplication=").append("amap")
                .append("&lat=").append(endPoint.latitude)
                .append("&lon=").append(endPoint.longitude)
                .append("&dev=").append(0);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer.toString()));
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.setPackage("com.autonavi.minimap");
        startActivity(intent);
    }

    /**
     * 跳转腾讯地图
     */
    private void goToTengxunMap(String lat, String lon, String descAddress) {
        if (!isInstalled("com.tencent.map")) {
            ToastUtil.showShortToast("请先安装腾讯地图客户端");
            return;
        }
        LatLng endPoint = BD2GCJ(new LatLng(Double.parseDouble(lat), Double.parseDouble(lon)));//坐标转换
        StringBuffer stringBuffer = new StringBuffer("qqmap://map/routeplan?type=bike")
                .append("&tocoord=").append(endPoint.latitude).append(",").append(endPoint.longitude).append("&to=" + descAddress);
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(stringBuffer.toString()));
        startActivity(intent);
    }

    /**
     * 跳转百度地图
     */
    private void goToBaiduMap(String descAddress) {
        if (!isInstalled("com.baidu.BaiduMap")) {
            ToastUtil.showShortToast("请先安装百度地图客户端");
            return;
        }
        Intent intent = new Intent();
        intent.setData(Uri.parse("baidumap://map/direction?destination="
                + descAddress + // 终点
                "&mode=riding" + // 导航路线方式
                "&coord_type=bd09ll" + // 坐标系
                "&src=" + getPackageName()));
        startActivity(intent); // 启动调用
    }

    /**
     * 检测程序是否安装
     *
     * @param packageName
     * @return
     */
    private boolean isInstalled(String packageName) {
        PackageManager manager = this.getPackageManager();
        //获取所有已安装程序的包信息
        List<PackageInfo> installedPackages = manager.getInstalledPackages(0);
        if (installedPackages != null) {
            for (PackageInfo info : installedPackages) {
                if (info.packageName.equals(packageName))
                    return true;
            }
        }
        return false;
    }

    @Override
    public void resultOrderAliPay(AliPayBean data) {
        new AliPay(UserConfirmationOrderActivity.this, data.getData().getData(), true);
    }

    @Override
    public void resultOrderWeiXinPay(WeChatPayBean data) {
        IWXAPI api = WXAPIFactory.createWXAPI(this, null);
        api.registerApp("wx1a65c563b86ec579");
        PayReq req = new PayReq();
        req.appId = data.getData().getData().getAppid();//你的微信appid
        req.partnerId = data.getData().getData().getPartnerid();//商户号
        req.prepayId = data.getData().getData().getPrepayid();//预支付交易会话ID
        req.nonceStr = data.getData().getData().getNoncestr();//随机字符串
        req.timeStamp = data.getData().getData().getTimestamp() + "";//时间戳
        req.packageValue = data.getData().getData().getPackageX(); //扩展字段, 这里固定填写Sign = WXPay
        req.sign = data.getData().getData().getSign();//签名
        //  req.extData         = "app data"; // optional
        // 在支付之前，如果应用没有注册到微信，应该先调用IWXMsg.registerApp将应用注册到微信
        api.sendReq(req);
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
