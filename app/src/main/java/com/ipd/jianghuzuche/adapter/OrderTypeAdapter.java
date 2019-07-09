package com.ipd.jianghuzuche.adapter;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.bean.SelectOrderTypeBean;
import com.ipd.jianghuzuche.utils.ApplicationUtil;

import java.util.List;

import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_LOCAL_URL;

/**
 * Description ：
 * Author ： MengYang
 * Email ： 942685687@qq.com
 * Time ： 2019/5/3.
 */
public class OrderTypeAdapter extends BaseQuickAdapter<SelectOrderTypeBean.DataBean.OrderListBean, BaseViewHolder> {
    private int type;

    public OrderTypeAdapter(@Nullable List<SelectOrderTypeBean.DataBean.OrderListBean> data, int type) {
        super(R.layout.adapter_order_type, data);
        this.type = type;
    }

    @Override
    protected void convert(BaseViewHolder helper, SelectOrderTypeBean.DataBean.OrderListBean item) {
        helper.setText(R.id.tv_order_num, item.getOrderNo())
                .setText(R.id.tv_order_type_brand, item.getVehicleName())
                .setText(R.id.tv_order_type_introduce, item.getVehicleModel())
                .setText(R.id.tv_order_type_location, item.getDescAddress())
                .setText(R.id.tv_order_type_store_name, item.getStoreName())
                .setText(R.id.tv_order_type_get_car_time, item.getTakevehicleTime() + "（" + item.getWeek() + "）")
                .setText(R.id.tv_order_type_use_car_time, item.getRentDuration() + "个月")
                .addOnClickListener(R.id.bt_order_type_start)
                .addOnClickListener(R.id.bt_order_type_end);
        switch (item.getStatus()) {
            case 2:
                helper.setGone(R.id.bt_order_type_start, false)
                        .setGone(R.id.bt_order_type_end, false)
                        .setGone(R.id.view_line, false)
                        .setText(R.id.tv_order_type, "已取消");
                break;
            case 3:
                helper.setText(R.id.bt_order_type_start, "取消订单")
                        .setText(R.id.tv_order_type, "待付款")
                        .setText(R.id.bt_order_type_end, "去付款")
                        .setGone(R.id.bt_order_type_start, true)
                        .setGone(R.id.bt_order_type_end, true)
                        .setGone(R.id.view_line, true);
                break;
            case 4:
                helper.setText(R.id.bt_order_type_start, "取消订单")
                        .setText(R.id.tv_order_type, "待取车")
                        .setText(R.id.bt_order_type_end, "查看车辆")
                        .setGone(R.id.bt_order_type_start, true)
                        .setGone(R.id.bt_order_type_end, true)
                        .setGone(R.id.view_line, true);
                break;
            case 5:
                switch (item.getTakeStatus()) {
                    case 1:
                        helper.setText(R.id.bt_order_type_end, "提前还车");
                        break;
                    case 2:
                        helper.setText(R.id.bt_order_type_end, "查看退车单");
                        break;
                }
                helper.setText(R.id.bt_order_type_start, "延长租期")
                        .setText(R.id.tv_order_type, "使用中")
                        .setGone(R.id.bt_order_type_start, true)
                        .setGone(R.id.bt_order_type_end, true)
                        .setGone(R.id.view_line, true);
                break;
            case 7:
                switch (item.getTakeStatus()) {
                    case 1:
                        helper.setText(R.id.bt_order_type_end, "申请退车");
                        break;
                    case 2:
                        helper.setText(R.id.bt_order_type_end, "查看退车单");
                        break;
                }
                helper.setText(R.id.bt_order_type_start, "延长租期")
                        .setText(R.id.tv_order_type, "已到期")
                        .setGone(R.id.bt_order_type_start, true)
                        .setGone(R.id.bt_order_type_end, true)
                        .setGone(R.id.view_line, true);
                break;
            case 8:
                helper.setGone(R.id.bt_order_type_start, false)
                        .setGone(R.id.bt_order_type_end, false)
                        .setGone(R.id.view_line, false)
                        .setText(R.id.tv_order_type, "已完成");
                break;
        }
        Glide.with(ApplicationUtil.getContext()).load(BASE_LOCAL_URL + item.getVehicleLogo()).apply(new RequestOptions().placeholder(R.mipmap.ic_launcher)).into((ImageView) helper.getView(R.id.iv_order_type));
    }
}
