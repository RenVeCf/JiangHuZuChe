package com.ipd.jianghuzuche.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.bean.RepairConfirmBean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/5.
 */
public class OrderOnlineAdapter extends BaseQuickAdapter<RepairConfirmBean.DataBean.CostListBean, BaseViewHolder> {


    public OrderOnlineAdapter(@Nullable List<RepairConfirmBean.DataBean.CostListBean> data) {
        super(R.layout.adapter_order_online, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RepairConfirmBean.DataBean.CostListBean item) {
        helper.setText(R.id.tv_repair_name, item.getTitle())
                .setText(R.id.tv_repair_fee, item.getMoney() + "元");
    }
}
