package com.ipd.jianghuzuche.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.LoginBean;
import com.ipd.jianghuzuche.contract.LoginContract;
import com.ipd.jianghuzuche.presenter.LoginPresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.MD5Utils;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.StringUtils;
import com.ipd.jianghuzuche.utils.ToastUtil;
import com.ipd.jianghuzuche.utils.VerifyUtils;

import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import cn.jpush.android.api.JPushInterface;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.AVATAR;
import static com.ipd.jianghuzuche.common.config.IConstants.INVITAION_CODE;
import static com.ipd.jianghuzuche.common.config.IConstants.IS_LOGIN;
import static com.ipd.jianghuzuche.common.config.IConstants.IS_SUPPLEMENT_INFO;
import static com.ipd.jianghuzuche.common.config.IConstants.JPUSH_SEQUENCE;
import static com.ipd.jianghuzuche.common.config.IConstants.NAME;
import static com.ipd.jianghuzuche.common.config.IConstants.PHONE;
import static com.ipd.jianghuzuche.common.config.IConstants.REVIEW;
import static com.ipd.jianghuzuche.common.config.IConstants.SERVICE_PHONE;
import static com.ipd.jianghuzuche.common.config.IConstants.USER_ID;
import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：登录
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/5.
 */
public class LoginActivity extends BaseActivity<LoginContract.View, LoginContract.Presenter> implements LoginContract.View {

    @BindView(R.id.et_login_phone)
    EditText etLoginPhone;
    @BindView(R.id.et_login_pwd)
    EditText etLoginPwd;
    @BindView(R.id.tv_forget_pwd)
    TextView tvForgetPwd;
    @BindView(R.id.tv_register)
    TextView tvRegister;
    @BindView(R.id.bt_login)
    Button btLogin;

    private long firstTime = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginContract.Presenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public LoginContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //自动登录
        if ((Boolean) (SPUtil.get(this, IS_SUPPLEMENT_INFO, false)) != false) {
            startActivity(new Intent(this, MainActivity.class));
            finish();
        } else if ((Boolean) (SPUtil.get(this, IS_LOGIN, false)) != false) {
            startActivity(new Intent(this, SupplementInfoActivity.class));
            finish();
        }
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {

    }

    /**
     * 双击退出程序
     */
    @Override
    public void onBackPressed() {
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 2000) {
            ToastUtil.showShortToast(getResources().getString(R.string.click_out_again));
            firstTime = secondTime;
        } else {
            ApplicationUtil.getManager().exitApp();
        }
    }

    @OnClick({R.id.tv_forget_pwd, R.id.tv_register, R.id.bt_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_forget_pwd:
                startActivity(new Intent(this, ForgetPasswordActivity.class));
                finish();
                break;
            case R.id.tv_register:
                startActivity(new Intent(this, RegisterActivity.class));
                finish();
                break;
            case R.id.bt_login:
                if (etLoginPhone.getText().toString().trim().length() == 11 && VerifyUtils.isMobileNumber(etLoginPhone.getText().toString().trim()) && etLoginPwd.getText().toString().trim().length() >= 6 && etLoginPwd.getText().toString().trim().length() <= 16) {
                    TreeMap<String, String> loginMap = new TreeMap<>();
                    //获取手机号码
                    loginMap.put("telPhone", etLoginPhone.getText().toString().trim());
                    //获取密码
                    loginMap.put("password", etLoginPwd.getText().toString().trim());
                    loginMap.put("sign", StringUtils.toUpperCase(MD5Utils.encodeMD5(loginMap.toString().replaceAll(" ", "") + "f9a75bb045d75998e1509b75ed3a5225")));
                    getPresenter().getLogin(loginMap, true, false);
                } else if (etLoginPhone.getText().toString().trim().length() != 11 || !VerifyUtils.isMobileNumber(etLoginPhone.getText().toString().trim())) {
                    ToastUtil.showShortToast(getString(R.string.error_phone_num));
                } else if (etLoginPwd.getText().toString().trim().length() < 6 || etLoginPwd.getText().toString().trim().length() > 16) {
                    ToastUtil.showLongToast(getResources().getString(R.string.error_pwd));
                }
                break;
        }
    }

    @Override
    public void resultLogin(LoginBean data) {
        ToastUtil.showLongToast(data.getMsg());
        if (data.getCode() == 200) {
            SPUtil.put(this, IS_LOGIN, true);
            SPUtil.put(this, USER_ID, data.getData().getUser().getUserId() + "");
            SPUtil.put(this, NAME, data.getData().getUser().getUserName());
            SPUtil.put(this, PHONE, data.getData().getUser().getTelPhone());
            SPUtil.put(this, SERVICE_PHONE, data.getData().getTelPhone());
            SPUtil.put(this, INVITAION_CODE, data.getData().getUser().getInvitationCode());
            SPUtil.put(this, AVATAR, BASE_LOCAL_URL + data.getData().getUser().getAvatar());
            JPushInterface.setAlias(this, JPUSH_SEQUENCE, "jhzc" + data.getData().getUser().getTelPhone());
            //用户状态： status  1.未上传资料 2正常4.审核中 5.已拒绝
            SPUtil.put(this, REVIEW, data.getData().getUser().getStatus() + "");
            if (data.getData().getUser().getStatus() == 1)
                startActivity(new Intent(this, SupplementInfoActivity.class).putExtra("review_type", 1));
            else if (data.getData().getUser().getStatus() == 2) {
                SPUtil.put(this, IS_SUPPLEMENT_INFO, true);
                startActivity(new Intent(this, MainActivity.class));
                finish();
            } else if (data.getData().getUser().getStatus() == 4) {
                startActivity(new Intent(this, SupplementInfoActivity.class).putExtra("review_type", 4));
            } else if (data.getData().getUser().getStatus() == 5) {
                startActivity(new Intent(this, SupplementInfoActivity.class).putExtra("review_type", 5));
            }
        }
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
