package com.ipd.jianghuzuche.fragment;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.adapter.RepairProjectVerticalAdapter;
import com.ipd.jianghuzuche.base.BaseFragment;
import com.ipd.jianghuzuche.base.BasePresenter;
import com.ipd.jianghuzuche.base.BaseView;
import com.ipd.jianghuzuche.bean.RepairProjectHorizontalBean;
import com.ipd.jianghuzuche.common.view.DividerItemDecoration;
import com.ipd.jianghuzuche.utils.LogUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;

/**
 * Description ：门店详情中的（维修项目）
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/5.
 */
public class RepairProjectVerticalFragment extends BaseFragment {

    @BindView(R.id.rv_repair_project_vertical)
    RecyclerView rvRepairProjectVertical;

    private List<RepairProjectHorizontalBean.DataBean.RepairTypeBean> repairTypeBean;
    private RepairProjectVerticalAdapter repairProjectVerticalAdapter;
    private int statusPosition;
    private CheckBox cb;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_repair_project_vertical;
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public BaseView createView() {
        return null;
    }

    @Override
    public void init() {
        // 设置管理器
        GridLayoutManager NotUseList = new GridLayoutManager(getActivity(), 4);
        rvRepairProjectVertical.setLayoutManager(NotUseList);
        rvRepairProjectVertical.addItemDecoration(new DividerItemDecoration(getActivity()));
        rvRepairProjectVertical.setHasFixedSize(true); //item如果一样的大小，可以设置为true让RecyclerView避免重新计算大小
        rvRepairProjectVertical.setItemAnimator(new DefaultItemAnimator()); //默认动画

        Bundle args = getArguments();
        if (args != null) {
            repairTypeBean = args.getParcelableArrayList("store_details");
            statusPosition = args.getInt("status_position");
        }

        repairProjectVerticalAdapter = new RepairProjectVerticalAdapter(repairTypeBean.get(statusPosition).getAppRepairs());
        rvRepairProjectVertical.setAdapter(repairProjectVerticalAdapter);
    }

    @Override
    public void initListener() {
        repairProjectVerticalAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                cb = (CheckBox) view;
                if (cb.isChecked())
                    repairTypeBean.get(statusPosition).getAppRepairs().get(position).setSelectStatus(1);
                else
                    repairTypeBean.get(statusPosition).getAppRepairs().get(position).setSelectStatus(0);
            }
        });
    }

    @Override
    public void initData() {
    }

    public String getLoadStringTwo() {
        List<Map<String, String>> listMap = new ArrayList<>();
        for (RepairProjectHorizontalBean.DataBean.RepairTypeBean chargeList : repairTypeBean) {
            for (RepairProjectHorizontalBean.DataBean.RepairTypeBean.AppRepairsBean appVehicleStatusBean : chargeList.getAppRepairs()) {
                if (appVehicleStatusBean.getSelectStatus() == 1) {
                    Map<String, String> map = new HashMap<>();
                    map.put("repairId", appVehicleStatusBean.getRepairId() + "");
                    map.put("repairCost", appVehicleStatusBean.getRepairCost() + "");
                    map.put("repairName", appVehicleStatusBean.getRepairName() + "");
                    listMap.add(map);
                }
            }
        }
        if (listMap.size() <= 0)
            return "";
        Gson g = new Gson();
        String jsonString = g.toJson(listMap);
        return jsonString;
    }
}
