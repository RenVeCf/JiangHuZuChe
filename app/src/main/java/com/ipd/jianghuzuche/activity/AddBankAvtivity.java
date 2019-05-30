package com.ipd.jianghuzuche.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.listener.CustomListener;
import com.bigkoo.pickerview.listener.OnOptionsSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.AddBankBean;
import com.ipd.jianghuzuche.bean.SelectOpeningBankBean;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.SelectOpeningBankContract;
import com.ipd.jianghuzuche.presenter.SelectOpeningBankPresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.USER_ID;

/**
 * Description ：添加银行卡
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/6.
 */
public class AddBankAvtivity extends BaseActivity<SelectOpeningBankContract.View, SelectOpeningBankContract.Presenter> implements SelectOpeningBankContract.View {

    @BindView(R.id.tv_add_bank_top)
    TopView tvAddBankTop;
    @BindView(R.id.tv_select_opening_bank)
    TextView tvSelectOpeningBank;
    @BindView(R.id.et_select_city_bank)
    EditText etSelectCityBank;
    @BindView(R.id.et_select_account_bank)
    EditText etSelectAccountBank;
    @BindView(R.id.et_select_name_bank)
    EditText etSelectNameBank;
    @BindView(R.id.bt_select_add_bank)
    Button btSelectAddBank;

    private OptionsPickerView pvOptions;
    private String bankcardId;
    private List<String> listData;
    private List<SelectOpeningBankBean.DataBean.BankcardListBean> bankcardListBean;

    @Override
    public int getLayoutId() {
        return R.layout.activity_add_bank_avtivity;
    }

    @Override
    public SelectOpeningBankContract.Presenter createPresenter() {
        return new SelectOpeningBankPresenter(this);
    }

    @Override
    public SelectOpeningBankContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvAddBankTop);

        bankcardListBean = new ArrayList<>();
        listData = new ArrayList<>();
    }

    @Override
    public void initListener() {

    }

    @Override
    public void initData() {
        getPresenter().getSelectOpeningBank(true, false);
    }

    //条件选择器
    private void showPickerView() {
        listData.clear();
        for (int i = 0; i < bankcardListBean.size(); i++) {
            listData.add(bankcardListBean.get(i).getBankcardName());
        }

        InputMethodManager imm = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
        // 隐藏软键盘
        imm.hideSoftInputFromWindow(this.getWindow().getDecorView().getWindowToken(), 0);
        pvOptions = new OptionsPickerBuilder(this, new OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3, View v) {
                tvSelectOpeningBank.setText(listData.get(options1));
                bankcardId = bankcardListBean.get(options1).getBankcardId() + "";
            }
        })
                .setDividerColor(getResources().getColor(R.color.white))//设置分割线的颜色
                .setLineSpacingMultiplier(1.6f)//设置两横线之间的间隔倍数
                .setLayoutRes(R.layout.pickerview_custom_options, new CustomListener() {
                    @Override
                    public void customLayout(View v) {
                        final Button tvSubmit = (Button) v.findViewById(R.id.bt_pickview_confirm);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvOptions.returnData();
                                pvOptions.dismiss();
                            }
                        });
                    }
                })
                .setSelectOptions(0)//设置选择第一个
                .setOutSideCancelable(true)//点击背的地方不消失
                .build();//创建
        pvOptions.setPicker(listData);
        pvOptions.show();
    }

    @Override
    public void resultSelectOpeningBank(SelectOpeningBankBean data) {
        bankcardListBean.clear();
        bankcardListBean.addAll(data.getData().getBankcardList());
    }

    @Override
    public void resultAddBank(AddBankBean data) {
        ToastUtil.showShortToast(data.getMsg());
        if (data.getCode() == 200) {
            setResult(RESULT_OK, new Intent().putExtra("refresh", 0));
            finish();
        }
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }

    @OnClick({R.id.tv_select_opening_bank, R.id.bt_select_add_bank})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_select_opening_bank:
                showPickerView();
                break;
            case R.id.bt_select_add_bank:
                if (!tvSelectOpeningBank.getText().toString().trim().equals("") && !etSelectCityBank.getText().toString().trim().equals("") && !etSelectAccountBank.getText().toString().trim().equals("") && !etSelectNameBank.getText().toString().trim().equals("")) {
                    TreeMap<String, String> addBankMap = new TreeMap<>();
                    addBankMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
                    addBankMap.put("bankcardId", bankcardId);
                    addBankMap.put("city", etSelectCityBank.getText().toString().trim());
                    addBankMap.put("cardholder", etSelectNameBank.getText().toString().trim());
                    addBankMap.put("cardNum", etSelectAccountBank.getText().toString().trim());
                    getPresenter().getAddBank(addBankMap, true, false);
                } else
                    ToastUtil.showLongToast("请填写完整信息!");
                break;
        }
    }
}
