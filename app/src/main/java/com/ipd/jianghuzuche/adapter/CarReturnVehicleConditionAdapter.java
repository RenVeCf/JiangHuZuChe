package com.ipd.jianghuzuche.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.bean.CarReturnDetailsBean;

import java.util.List;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/13.
 */
public class CarReturnVehicleConditionAdapter extends BaseQuickAdapter<CarReturnDetailsBean.DataBean.VehicleOrstatusBean, BaseViewHolder> {

    private String vehicleConditionType;
    private TextView tvVehicleConditionFee;

    public CarReturnVehicleConditionAdapter(@Nullable List<CarReturnDetailsBean.DataBean.VehicleOrstatusBean> data) {
        super(R.layout.adapter_vehicle_condition, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, CarReturnDetailsBean.DataBean.VehicleOrstatusBean item) {
        tvVehicleConditionFee = helper.getView(R.id.tv_vehicle_condition_fee);
        switch (item.getStatus()) {
            case 1:
                vehicleConditionType = "正常";
                tvVehicleConditionFee.setVisibility(View.GONE);
                break;
            case 2:
                vehicleConditionType = "破损";
                tvVehicleConditionFee.setVisibility(View.VISIBLE);
                tvVehicleConditionFee.setText("-" + item.getDamagedCost() + "元");
                break;
        }
        helper.setText(R.id.tv_vehicle_condition_name, item.getVestatusName())
                .setText(R.id.tv_vehicle_condition_type, vehicleConditionType);
    }
}
