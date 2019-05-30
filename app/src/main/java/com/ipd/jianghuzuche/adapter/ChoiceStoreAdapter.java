package com.ipd.jianghuzuche.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.bean.ChoiceStoreBean;
import com.ipd.jianghuzuche.utils.NumberUtils;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/5.
 */
public class ChoiceStoreAdapter extends BaseQuickAdapter<ChoiceStoreBean.DataBean.StoreListBean, BaseViewHolder> {
    public ChoiceStoreAdapter(@Nullable List<ChoiceStoreBean.DataBean.StoreListBean> data) {
        super(R.layout.adapter_choice_store, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ChoiceStoreBean.DataBean.StoreListBean item) {
        helper.setText(R.id.tv_store_name, item.getStoreName())
                .setText(R.id.tv_store_distance, NumberUtils.formatTwoDecimal((float) item.getDistance() / 1000) + "km")
                .setText(R.id.tv_store_path, item.getDescAddress())
                .setText(R.id.tv_store_stock, "库存: " + item.getAvailableNum())
                .addOnClickListener(R.id.tv_go_store)
                .addOnClickListener(R.id.tv_store_distance)
                .addOnClickListener(R.id.ll_go_store_details);
    }
}
