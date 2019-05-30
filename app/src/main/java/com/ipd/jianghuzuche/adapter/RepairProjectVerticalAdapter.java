package com.ipd.jianghuzuche.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.bean.RepairProjectHorizontalBean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/14.
 */
public class RepairProjectVerticalAdapter extends BaseQuickAdapter<RepairProjectHorizontalBean.DataBean.RepairTypeBean.AppRepairsBean, BaseViewHolder> {


    public RepairProjectVerticalAdapter(@Nullable List<RepairProjectHorizontalBean.DataBean.RepairTypeBean.AppRepairsBean> data) {
        super(R.layout.adapter_repair_project_vertical, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, RepairProjectHorizontalBean.DataBean.RepairTypeBean.AppRepairsBean item) {
        helper.setText(R.id.cb_store_infor, item.getRepairName())
                .addOnClickListener(R.id.cb_store_infor);
    }
}
