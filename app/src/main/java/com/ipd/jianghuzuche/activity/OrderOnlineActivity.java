package com.ipd.jianghuzuche.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.adapter.OrderOnlineAdapter;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.AliPayBean;
import com.ipd.jianghuzuche.bean.RepairConfirmBean;
import com.ipd.jianghuzuche.bean.WeChatPayBean;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.OrderOnlineContract;
import com.ipd.jianghuzuche.presenter.OrderOnlinePresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.ToastUtil;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.REQUEST_CODE_93;
import static com.ipd.jianghuzuche.common.config.IConstants.USER_ID;
import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_LOCAL_URL;


/**
 * Description ：在线下单
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/4/29.
 */
public class OrderOnlineActivity extends BaseActivity<OrderOnlineContract.View, OrderOnlineContract.Presenter> implements OrderOnlineContract.View {
    @BindView(R.id.tv_order_online_top)
    TopView tvRepairOrderTop;
    @BindView(R.id.iv_user_confirmation_order)
    ImageView ivUserConfirmationOrder;
    @BindView(R.id.tv_store_name)
    TextView tvStoreName;
    @BindView(R.id.tv_go_choice_store)
    TextView tvGoChoiceStore;
    @BindView(R.id.tv_store_path)
    TextView tvStorePath;
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
    @BindView(R.id.cb_is_order_online)
    CheckBox cbIsRepairOrder;
    @BindView(R.id.tv_rule_of_order_online)
    TextView tvRuleOfRepairOrder;
    @BindView(R.id.iv_alipay)
    ImageView ivAlipay;
    @BindView(R.id.ll_alipay)
    LinearLayout llAlipay;
    @BindView(R.id.iv_weixin_pay)
    ImageView ivWeixinPay;
    @BindView(R.id.ll_weixin_pay)
    LinearLayout llWeixinPay;
    @BindView(R.id.bt_order_online)
    Button btRepairOrder;
    @BindView(R.id.rv_order_online)
    RecyclerView rvOrderOnline;

    private RepairConfirmBean.DataBean.OrderBean repairConfirmBean = new RepairConfirmBean.DataBean.OrderBean();
    private OrderOnlineAdapter choiceStoreAdapter;
    private List<RepairConfirmBean.DataBean.CostListBean> costListBean = new ArrayList<>();
    private int payType;
    private String coupon_name = "";
    private double coupon_money = 0;
    private double sumMoney = 0;
    private int couponId = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_order_online;
    }

    @Override
    public OrderOnlineContract.Presenter createPresenter() {
        return new OrderOnlinePresenter(this);
    }

    @Override
    public OrderOnlineContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvRepairOrderTop);

        repairConfirmBean = getIntent().getParcelableExtra("order_online");
        costListBean = getIntent().getParcelableArrayListExtra("order_online_list");

        // 设置管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvOrderOnline.setLayoutManager(layoutManager);
        rvOrderOnline.setNestedScrollingEnabled(false);
        rvOrderOnline.setHasFixedSize(true);
        rvOrderOnline.setItemAnimator(new DefaultItemAnimator());

        choiceStoreAdapter = new OrderOnlineAdapter(costListBean);
        rvOrderOnline.setAdapter(choiceStoreAdapter);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + repairConfirmBean.getLogo()).apply(new RequestOptions().placeholder(R.mipmap.ic_launcher)).into(ivUserConfirmationOrder);
        tvStoreName.setText(repairConfirmBean.getStoreName());
        tvStorePath.setText("地址: " + repairConfirmBean.getDescAddress());
        for (int i = 0; i < costListBean.size(); i++) {
            sumMoney += costListBean.get(i).getMoney();
        }
        tvUseCarMoneySum.setText(sumMoney + "元");
    }

    private void payType(int payType) {
        switch (payType) {
            case 0:
                TreeMap<String, String> aliMap = new TreeMap<>();
                aliMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
                aliMap.put("orderId", repairConfirmBean.getOrderId() + "");
                aliMap.put("money", tvUseCarMoneySum.getText().toString().trim());
                aliMap.put("coupon", coupon_money + "");
                aliMap.put("couponTitle", coupon_name);
                getPresenter().getRepairAli(aliMap, true, false);
                break;
            case 1:
                TreeMap<String, String> weCahatMap = new TreeMap<>();
                weCahatMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
                weCahatMap.put("orderId", repairConfirmBean.getOrderId() + "");
                weCahatMap.put("money", tvUseCarMoneySum.getText().toString().trim());
                weCahatMap.put("coupon", coupon_money + "");
                weCahatMap.put("couponTitle", coupon_name);
                getPresenter().getRepairWeChat(weCahatMap, true, false);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (requestCode) {
                case REQUEST_CODE_93:
                    couponId = data.getIntExtra("coupon_id", 0);
                    coupon_name = data.getStringExtra("coupon_name");
                    tvUseCarCouponName.setText(coupon_name);
                    tvUserConfirmationOrderCouponType.setText(coupon_name);
                    coupon_money = data.getDoubleExtra("coupon_money", 0);
                    tvUseCarCouponMoney.setText("-" + coupon_money + "元");
                    double i = sumMoney
                            - coupon_money;
                    tvUseCarMoneySum.setText(i + "元");
                    break;
            }
        }
    }

    @OnClick({R.id.tv_go_choice_store, R.id.ll_user_confirmation_order_coupon, R.id.ll_alipay, R.id.ll_weixin_pay, R.id.bt_order_online})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_go_choice_store:
                goToBaiduMap(repairConfirmBean.getDescAddress());
                break;
            case R.id.ll_user_confirmation_order_coupon:
                startActivityForResult(new Intent(this, UserCouponActivity.class).putExtra("money", Double.parseDouble(tvUseCarMoneySum.getText().toString().trim().replaceAll("元", ""))).putExtra("coupon_id", couponId), REQUEST_CODE_93);
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
            case R.id.bt_order_online:
                if (cbIsRepairOrder.isChecked())
                    payType(payType);
                else
                    ToastUtil.showShortToast("请勾选维修订单规则");
                break;
        }
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
//        Intent intent = new Intent();
//        intent.setData(Uri.parse("baidumap://map/direction?destination=latlng:"
//                + latitude + ","
//                + longitude + "|name:" + descAddress + // 终点
//                "&mode=riding" + // 导航路线方式
//                "&coord_type=bd09ll" + // 坐标系
//                "&src=" + getPackageName()));
//        startActivity(intent); // 启动调用
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
    public void resultRepairAli(AliPayBean data) {
        new AliPay(OrderOnlineActivity.this, data.getData().getData());
    }

    @Override
    public void resultRepairWeChat(WeChatPayBean data) {
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
