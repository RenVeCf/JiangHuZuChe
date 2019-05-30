package com.ipd.jianghuzuche.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.bean.UserSelectCarBean;
import com.ipd.jianghuzuche.utils.ApplicationUtil;

import java.util.List;

import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/4/30.
 */
public class UserSelectCarAdapter extends BaseQuickAdapter<UserSelectCarBean.DataBean.VehicleListBean, BaseViewHolder> {
    public UserSelectCarAdapter(@Nullable List<UserSelectCarBean.DataBean.VehicleListBean> data) {
        super(R.layout.adapter_user_select_car, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, UserSelectCarBean.DataBean.VehicleListBean item) {
        helper.setText(R.id.tv_user_select_car_brand, item.getVehicleName())
                .setText(R.id.tv_user_select_car_introduce, item.getVehicleModel())
                .setText(R.id.tv_user_select_car_money, "¥ " + item.getVehicleRent())
                .setText(R.id.tv_rent_month, "/月")
                .setText(R.id.tv_rent_min_month, item.getRentOften() + "个月起租")
                .setText(R.id.tv_deposit, "押金: " + item.getDeposit());
        Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + item.getVehicleLogo()).apply(new RequestOptions().placeholder(R.mipmap.ic_launcher)).into((ImageView) helper.getView(R.id.iv_user_select_car));
    }
}
