package com.ipd.jianghuzuche.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.base.BasePresenter;
import com.ipd.jianghuzuche.base.BaseView;
import com.ipd.jianghuzuche.bean.UserSelectCarBean;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.utils.ApplicationUtil;

import butterknife.BindView;
import butterknife.OnClick;

import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：车辆详情
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/6.
 */
public class CarDetailsActivity extends BaseActivity {

    @BindView(R.id.tv_car_details_top)
    TopView tvCarDetailsTop;
    @BindView(R.id.tv_car_name)
    TextView tvCarName;
    @BindView(R.id.tv_car_model)
    TextView tvCarModel;
    @BindView(R.id.bt_car_details)
    Button btCarDetails;
    @BindView(R.id.iv_car_details)
    ImageView ivCarDetails;
    @BindView(R.id.tv_car_money)
    TextView tvCarMoney;
    @BindView(R.id.tv_deposit)
    TextView tvDeposit;
    @BindView(R.id.wv_car_details)
    WebView wvCarDetails;

    private UserSelectCarBean.DataBean.VehicleListBean userSelectCarBean = new UserSelectCarBean.DataBean.VehicleListBean();

    @Override
    public int getLayoutId() {
        return R.layout.activity_car_details;
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public BaseView createView() {
        return null;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvCarDetailsTop);

        userSelectCarBean = getIntent().getParcelableExtra("car_details");

        WebSettings settings = wvCarDetails.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setUseWideViewPort(true);
        settings.setLoadWithOverviewMode(true);
        wvCarDetails.setWebViewClient(new MyWebViewClient(this));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.TEXT_AUTOSIZING);
        } else {
            settings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        }
        wvCarDetails.loadData(getHtmlData(userSelectCarBean.getDetails()), "text/html;charset=utf-8", "utf-8");
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        tvCarName.setText(userSelectCarBean.getVehicleName());
        tvDeposit.setText("押金: " + userSelectCarBean.getDeposit());
        tvCarModel.setText(userSelectCarBean.getVehicleModel());
        tvCarMoney.setText("¥ " + userSelectCarBean.getVehicleRent());
        Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + userSelectCarBean.getVehicleLogo()).apply(new RequestOptions().placeholder(R.mipmap.ic_launcher)).into(ivCarDetails);
    }

    private String getHtmlData(String bodyHTML) {
        String head = "<head>" +
                "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, user-scalable=no\"> " +
                "<style>html{padding:15px;} body{word-wrap:break-word;font-size:13px;padding:0px;margin:0px} p{padding:0px;margin:0px;font-size:13px;color:#222222;line-height:1.3;} img{padding:0px,margin:0px;max-width:100%; width:auto; height:auto;}</style>" +
                "</head>";
        return "<html>" + head + "<body>" + bodyHTML + "</body></html>";
    }

    static class MyWebViewClient extends WebViewClient {
        private Dialog dialog;
        private Activity activity;

        public MyWebViewClient(Activity activity) {
            dialog = new Dialog(activity);
            this.activity = activity;
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
            if (!activity.isFinishing()) dialog.show();
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed();
            super.onReceivedSslError(view, handler, error);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (!activity.isFinishing()) dialog.dismiss();
        }
    }

    @OnClick(R.id.bt_car_details)
    public void onViewClicked() {
        startActivity(new Intent(this, UserConfirmationOrderActivity.class).putExtra("car_details", userSelectCarBean));
    }
}
