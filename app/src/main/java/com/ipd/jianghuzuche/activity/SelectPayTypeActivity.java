package com.ipd.jianghuzuche.activity;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.aliPay.AliPay;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.AliPayBean;
import com.ipd.jianghuzuche.bean.WeChatPayBean;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.SelectTypePayContract;
import com.ipd.jianghuzuche.presenter.SelectTypePayPresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.MD5Utils;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.StringUtils;
import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.USER_ID;

/**
 * Description ：选择支付方式
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/6.
 */
public class SelectPayTypeActivity extends BaseActivity<SelectTypePayContract.View, SelectTypePayContract.Presenter> implements SelectTypePayContract.View {

    @BindView(R.id.tv_select_pay_type_top)
    TopView tvSelectPayTypeTop;
    @BindView(R.id.iv_alipay)
    ImageView ivAlipay;
    @BindView(R.id.ll_alipay)
    LinearLayout llAlipay;
    @BindView(R.id.iv_weixin_pay)
    ImageView ivWeixinPay;
    @BindView(R.id.ll_weixin_pay)
    LinearLayout llWeixinPay;
    @BindView(R.id.bt_select_pay_type)
    Button btSelectPayType;

    private int orderId;
    private int payType;

    @Override
    public int getLayoutId() {
        return R.layout.activity_select_pay_type;
    }

    @Override
    public SelectTypePayContract.Presenter createPresenter() {
        return new SelectTypePayPresenter(this);
    }

    @Override
    public SelectTypePayContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvSelectPayTypeTop);

        orderId = getIntent().getIntExtra("order_id", 0);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
    }

    private void payType(int payType) {
        switch (payType) {
            case 0:
                TreeMap<String, String> aliPayMap = new TreeMap<>();
                aliPayMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
                aliPayMap.put("orderId", orderId + "");
                aliPayMap.put("sign", StringUtils.toUpperCase(MD5Utils.encodeMD5(aliPayMap.toString().replaceAll(" ", "") + "f9a75bb045d75998e1509b75ed3a5225")));
                getPresenter().getSelectTypePayAli(aliPayMap, true, false);
                break;
            case 1:
                TreeMap<String, String> weixinPayMap = new TreeMap<>();
                weixinPayMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
                weixinPayMap.put("orderId", orderId + "");
                weixinPayMap.put("sign", StringUtils.toUpperCase(MD5Utils.encodeMD5(weixinPayMap.toString().replaceAll(" ", "") + "f9a75bb045d75998e1509b75ed3a5225")));
                getPresenter().getSelectTypePayWeChat(weixinPayMap, true, false);
                break;
        }
    }

    @OnClick({R.id.ll_alipay, R.id.ll_weixin_pay, R.id.bt_select_pay_type})
    public void onViewClicked(View view) {
        switch (view.getId()) {
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
            case R.id.bt_select_pay_type:
                payType(payType);
//                startActivity(new Intent(this, PayTypeActivity.class).putExtra("pay_type", 0));
                break;
        }
    }

    @Override
    public void resultSelectTypePayAli(AliPayBean data) {
        new AliPay(SelectPayTypeActivity.this, data.getData().getData(), false);
    }

    @Override
    public void resultSelectTypePayWeChat(WeChatPayBean data) {
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
