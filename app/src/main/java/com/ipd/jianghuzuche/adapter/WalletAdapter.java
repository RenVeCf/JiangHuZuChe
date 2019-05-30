package com.ipd.jianghuzuche.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.bean.WalletDetailsBean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/7.
 */
public class WalletAdapter extends BaseQuickAdapter<WalletDetailsBean.DataBean.UserDetailedBean, BaseViewHolder> {

    private String MoneyType;

    public WalletAdapter(@Nullable List<WalletDetailsBean.DataBean.UserDetailedBean> data) {
        super(R.layout.adapter_wallet, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, WalletDetailsBean.DataBean.UserDetailedBean item) {
        switch (item.getMoneyType()) {
            case 1:
                MoneyType = "+";
                break;
            case 2:
                MoneyType = "-";
                break;
        }
        helper.setText(R.id.tv_wallet_money, MoneyType + item.getMoney())
                .setText(R.id.tv_wallet_time, item.getCreateTime() + "");
    }
}
