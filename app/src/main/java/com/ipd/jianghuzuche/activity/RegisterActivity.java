package com.ipd.jianghuzuche.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.CaptchaBean;
import com.ipd.jianghuzuche.bean.RegisterBean;
import com.ipd.jianghuzuche.common.config.IConstants;
import com.ipd.jianghuzuche.contract.RegisterContract;
import com.ipd.jianghuzuche.presenter.RegisterPresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.CountDownUtil;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.ToastUtil;
import com.ipd.jianghuzuche.utils.VerifyUtils;
import com.ipd.jianghuzuche.utils.isClickUtil;

import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.INVITAION_CODE;
import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：注册
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/5.
 */
public class RegisterActivity extends BaseActivity<RegisterContract.View, RegisterContract.Presenter> implements RegisterContract.View {

    @BindView(R.id.et_register_phone)
    EditText etRegisterPhone;
    @BindView(R.id.et_register_verification_code)
    EditText etRegisterVerificationCode;
    @BindView(R.id.bt_get_verification_code)
    Button btGetVerificationCode;
    @BindView(R.id.et_register_pwd)
    EditText etRegisterPwd;
    @BindView(R.id.et_invitation_code)
    EditText etInvitationCode;
    @BindView(R.id.cb_register)
    CheckBox cbRegister;
    @BindView(R.id.tv_register_login)
    TextView tvRegisterLogin;
    @BindView(R.id.bt_register)
    Button btRegister;
    @BindView(R.id.tv_user_agreement)
    TextView tvUserAgreement;

    private long firstTime = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public RegisterContract.Presenter createPresenter() {
        return new RegisterPresenter(this);
    }

    @Override
    public RegisterContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
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

    @OnClick({R.id.tv_user_agreement, R.id.bt_get_verification_code, R.id.tv_register_login, R.id.bt_register})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_user_agreement:
                startActivity(new Intent(this, WebViewActivity.class).putExtra("h5Type", 0));
                break;
            case R.id.bt_get_verification_code:
                if (etRegisterPhone.getText().toString().trim().length() == 11 && VerifyUtils.isMobileNumber(etRegisterPhone.getText().toString().trim())) {
                    TreeMap<String, String> captchaMap = new TreeMap<>();
                    //获取手机号码
                    captchaMap.put("telPhone", etRegisterPhone.getText().toString().trim());
                    getPresenter().getCaptcha(captchaMap, true, false);
                } else {
                    ToastUtil.showShortToast(getString(R.string.error_phone_num));
                }
                break;
            case R.id.tv_register_login:
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                break;
            case R.id.bt_register:
                if (isClickUtil.isFastClick()) {
                    //手机号码的长度判断，验证码的长度判断，复选框状态
                    if (etRegisterPhone.getText().toString().trim().length() == 11 && VerifyUtils.isMobileNumber(etRegisterPhone.getText().toString().trim()) && etRegisterVerificationCode.getText().toString().trim().length() == 6 && VerifyUtils.isNumeric(etRegisterVerificationCode.getText().toString().trim()) && etRegisterPwd.getText().toString().trim().length() >= 6 && etRegisterPwd.getText().toString().trim().length() <= 16 && cbRegister.isChecked() == true) {
                        TreeMap<String, String> registerMap = new TreeMap<>();
                        registerMap.put("telPhone", etRegisterPhone.getText().toString().trim());
                        registerMap.put("password", etRegisterPwd.getText().toString().trim());
                        registerMap.put("invitationCode", etInvitationCode.getText().toString().trim());
                        registerMap.put("smsCode", etRegisterVerificationCode.getText().toString().trim());
                        getPresenter().getRegister(registerMap, true, false);
                    } else if (cbRegister.isChecked() == false) {
                        ToastUtil.showShortToast(getString(R.string.error_check_box));
                    } else if (etRegisterPhone.getText().toString().trim().length() != 11 || !VerifyUtils.isMobileNumber(etRegisterPhone.getText().toString().trim())) {
                        ToastUtil.showShortToast(getString(R.string.error_phone_num));
                    } else if (etRegisterVerificationCode.getText().toString().trim().length() != 6) {
                        ToastUtil.showLongToast(getResources().getString(R.string.six_length_captcha));
                    } else {
                        ToastUtil.showShortToast(getString(R.string.error_login));
                    }
                }
                break;
        }
    }

    @Override
    public void resultRegister(RegisterBean data) {
        ToastUtil.showLongToast(data.getMsg());
        if (data.getCode() == 200) {
            SPUtil.put(this, IConstants.IS_LOGIN, true);
            SPUtil.put(this, IConstants.USER_ID, data.getData().getUser().getUserId() + "");
            SPUtil.put(this, IConstants.NAME, data.getData().getUser().getUserName());
            SPUtil.put(this, IConstants.PHONE, data.getData().getUser().getTelPhone());
            SPUtil.put(this, INVITAION_CODE, data.getData().getUser().getInvitationCode());
            SPUtil.put(this, IConstants.AVATAR, BASE_LOCAL_URL + data.getData().getUser().getAvatar());

            startActivity(new Intent(this, SupplementInfoActivity.class));
            finish();
        }
    }

    @Override
    public void resultCaptcha(CaptchaBean data) {
        ToastUtil.showLongToast(data.getMsg());
        //验证码倒计时60内不能重新发送
        new CountDownUtil(btGetVerificationCode)
                .setCountDownMillis(60_000L)//倒计时60000ms
                .setCountDownColor(R.color.white, R.color.white)//不同状态字体颜色
                .setOnClickListener(new View.OnClickListener() {
                    //重新获取验证码
                    @Override
                    public void onClick(View v) {
                        if (etRegisterPhone.getText().toString().trim().length() == 11 && VerifyUtils.isMobileNumber(etRegisterPhone.getText().toString().trim())) {
                            TreeMap<String, String> captchaMap = new TreeMap<>();
                            //获取手机号码
                            captchaMap.put("telPhone", etRegisterPhone.getText().toString().trim());
                            getPresenter().getCaptcha(captchaMap, true, false);
                        } else {
                            ToastUtil.showShortToast(getString(R.string.error_phone_num));
                        }
                    }
                })
                .start();
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
