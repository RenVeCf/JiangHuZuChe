package com.ipd.jianghuzuche.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.CashWithdrawalBean;
import com.ipd.jianghuzuche.bean.CashWithdrawalFeeBean;
import com.ipd.jianghuzuche.bean.LastBankBean;
import com.ipd.jianghuzuche.bean.SelectBankBean;
import com.ipd.jianghuzuche.common.view.CircleImageView;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.CashWithdrawalFeeContract;
import com.ipd.jianghuzuche.presenter.CashWithdrawalFeePresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.ToastUtil;

import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.REQUEST_CODE_97;
import static com.ipd.jianghuzuche.common.config.IConstants.USER_ID;
import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：提现
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/7.
 */
public class CashWithdrawalActivity extends BaseActivity<CashWithdrawalFeeContract.View, CashWithdrawalFeeContract.Presenter> implements CashWithdrawalFeeContract.View {

    @BindView(R.id.tv_cash_withdrawal_top)
    TopView tvCashWithdrawalTop;
    @BindView(R.id.ll_select_bank_card)
    LinearLayout llSelectBankCard;
    @BindView(R.id.et_how_money)
    EditText etHowMoney;
    @BindView(R.id.bt_cash_withdrawal)
    Button btCashWithdrawal;
    @BindView(R.id.tv_put_conf)
    TextView tvPutConf;
    @BindView(R.id.iv_bank)
    CircleImageView ivBank;
    @BindView(R.id.tv_bank_name)
    TextView tvBankName;
    @BindView(R.id.tv_bank_num)
    TextView tvBankNum;
    @BindView(R.id.ll_last_bank_card)
    LinearLayout llLastBankCard;

    private int bankId = 0;
    private SelectBankBean.DataBean.BankListBean bankBean;
    private CashWithdrawalFeeBean.DataBean.PutConfBean putConfBean = new CashWithdrawalFeeBean.DataBean.PutConfBean();

    @Override
    public int getLayoutId() {
        return R.layout.activity_cash_withdrawal;
    }

    @Override
    public CashWithdrawalFeeContract.Presenter createPresenter() {
        return new CashWithdrawalFeePresenter(this);
    }

    @Override
    public CashWithdrawalFeeContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvCashWithdrawalTop);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        TreeMap<String, String> cashWithdrawalMap = new TreeMap<>();
        cashWithdrawalMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
        cashWithdrawalMap.put("type", "1");
        getPresenter().getCashWithdrawalFee(cashWithdrawalMap, false, false);

        TreeMap<String, String> lastBankMap = new TreeMap<>();
        lastBankMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
        getPresenter().getLastBank(lastBankMap, true, false);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (requestCode) {
                case REQUEST_CODE_97:
                    bankBean = data.getParcelableExtra("bankListBean");
                    bankId = bankBean.getBankId();
                    llSelectBankCard.setVisibility(View.GONE);
                    llLastBankCard.setVisibility(View.VISIBLE);

                    Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + bankBean.getBankIcon()).apply(new RequestOptions()).into(ivBank);
                    tvBankName.setText(bankBean.getBankName());
                    tvBankNum.setText("尾号" + (bankBean.getCardNum().substring((bankBean.getCardNum() + "").length() - 4)));
                    break;
            }
        }
    }

    @OnClick({R.id.ll_select_bank_card, R.id.ll_last_bank_card, R.id.bt_cash_withdrawal})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_select_bank_card:
                startActivityForResult(new Intent(this, SelectBankActivity.class), REQUEST_CODE_97);
                break;
            case R.id.ll_last_bank_card:
                startActivityForResult(new Intent(this, SelectBankActivity.class), REQUEST_CODE_97);
                break;
            case R.id.bt_cash_withdrawal:
                if (!etHowMoney.getText().toString().trim().equals(""))
                    if (Integer.parseInt(etHowMoney.getText().toString().trim()) > putConfBean.getMaxMoney() || Integer.parseInt(etHowMoney.getText().toString().trim()) < putConfBean.getMinMoney())
                        ToastUtil.showLongToast("单笔最高金额为: " + putConfBean.getMaxMoney() + ", 单笔最低金额为: " + putConfBean.getMinMoney());
                    else {
                        TreeMap<String, String> cashWithdrawalMap = new TreeMap<>();
                        cashWithdrawalMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
                        cashWithdrawalMap.put("bankId", bankId + "");
                        cashWithdrawalMap.put("putMoney", etHowMoney.getText().toString().trim());
                        getPresenter().getCashWithdrawal(cashWithdrawalMap, false, false);
                    }
                else
                    ToastUtil.showLongToast("请填写金额");
                break;
        }
    }

    @Override
    public void resultCashWithdrawalFee(CashWithdrawalFeeBean data) {
        putConfBean = data.getData().getPutConf();
        tvPutConf.setText("提现金额（收取" + putConfBean.getPutRate() + "%服务费）");
    }

    @Override
    public void resultCashWithdrawal(CashWithdrawalBean data) {
        ToastUtil.showLongToast(data.getMsg());
        if (data.getCode() == 200)
            startActivity(new Intent(this, PayTypeActivity.class).putExtra("pay_type", 2));
    }

    @Override
    public void resultLastBank(LastBankBean data) {
        if (data.getCode() == 200) {
            bankId = data.getData().getLatelyBank().getBankId();
            llSelectBankCard.setVisibility(View.GONE);
            llLastBankCard.setVisibility(View.VISIBLE);

            Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + data.getData().getLatelyBank().getBankIcon()).apply(new RequestOptions()).into(ivBank);
            tvBankName.setText(data.getData().getLatelyBank().getBankName());
            tvBankNum.setText("尾号" + (data.getData().getLatelyBank().getCardNum().substring((data.getData().getLatelyBank().getCardNum() + "").length() - 4)));
        }
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }
}
