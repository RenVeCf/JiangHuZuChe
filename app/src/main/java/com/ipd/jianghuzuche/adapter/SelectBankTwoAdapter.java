package com.ipd.jianghuzuche.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.bean.SelectBankBean;
import com.ipd.jianghuzuche.utils.ApplicationUtil;

import java.util.List;

import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/14.
 */
public class SelectBankTwoAdapter extends BaseQuickAdapter<SelectBankBean.DataBean.BankListBean, BaseViewHolder> {

    public SelectBankTwoAdapter(@Nullable List<SelectBankBean.DataBean.BankListBean> data) {
        super(R.layout.adapter_select_bank_two, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, SelectBankBean.DataBean.BankListBean item) {
        int i = helper.getLayoutPosition() % 2 == 1 ? 0 : 1;
        switch (i) {
            case 0:
                helper.setBackgroundRes(R.id.ll_select_bank_two, R.drawable.bg_bank_bule);
                break;
            case 1:
                helper.setBackgroundRes(R.id.ll_select_bank_two, R.drawable.bg_bank_red);
                break;
        }
        Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + item.getBankIcon()).apply(new RequestOptions().placeholder(R.mipmap.ic_launcher)).into((ImageView) helper.getView(R.id.iv_bank));
        helper.setText(R.id.tv_bank_name, item.getBankName())
                .setText(R.id.tv_select_bank_two, "**** **** **** " + (item.getCardNum().substring((item.getCardNum() + "").length() - 4)));
    }
}
