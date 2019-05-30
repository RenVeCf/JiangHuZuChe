package com.ipd.jianghuzuche.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.activity.RepairOrderDetailsActivity;
import com.ipd.jianghuzuche.adapter.RepairOrderAdapter;
import com.ipd.jianghuzuche.base.BaseFragment;
import com.ipd.jianghuzuche.bean.RepairOrderBean;
import com.ipd.jianghuzuche.contract.RepairOrderContract;
import com.ipd.jianghuzuche.presenter.RepairOrderPresenter;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.trello.rxlifecycle2.android.FragmentEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.USER_ID;

public class RepairOrderRuningFragment extends BaseFragment<RepairOrderContract.View, RepairOrderContract.Presenter> implements RepairOrderContract.View, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.rv_repair_order_runing)
    RecyclerView rvRepairOrderRuning;
    @BindView(R.id.srl_repair_order_runing)
    SwipeRefreshLayout srlRepairOrderRuning;

    private RepairOrderAdapter repairOrderAdapter;
    private List<RepairOrderBean.DataBean.OrderListBean> repairOrderBean;
    private int fmType;
    private int page;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_repair_order_runing;
    }

    @Override
    public RepairOrderContract.Presenter createPresenter() {
        return new RepairOrderPresenter(mContext);
    }

    @Override
    public RepairOrderContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        // 设置管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvRepairOrderRuning.setLayoutManager(layoutManager);
        // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rvRepairOrderRuning.setHasFixedSize(true);
        rvRepairOrderRuning.setItemAnimator(new DefaultItemAnimator());

        Bundle args = getArguments();
        if (args != null) {
            fmType = args.getInt("fm_type");
        }

        repairOrderBean = new ArrayList<>();
        repairOrderAdapter = new RepairOrderAdapter(repairOrderBean, fmType);
        rvRepairOrderRuning.setAdapter(repairOrderAdapter);
    }

    @Override
    public void initListener() {
        srlRepairOrderRuning.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 0;
                initData();
                srlRepairOrderRuning.setRefreshing(false);
            }
        });

        repairOrderAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                startActivity(new Intent(getActivity(), RepairOrderDetailsActivity.class).putExtra("order_id", repairOrderBean.get(position).getOrderId()));
            }
        });
    }

    @Override
    public void initData() {
        TreeMap<String, String> RepairOrderMap = new TreeMap<>();
        RepairOrderMap.put("userId", SPUtil.get(getActivity(), USER_ID, "") + "");
        switch (fmType) {
            case 0:
                RepairOrderMap.put("status", "4");
                break;
            case 1:
                RepairOrderMap.put("status", "5");
                break;
            case 2:
                RepairOrderMap.put("status", "2");
                break;
        }


        RepairOrderMap.put("page", page + "");
        getPresenter().getRepairOrder(RepairOrderMap, true, false);
    }

    @Override
    public void resultRepairOrder(RepairOrderBean data) {
        repairOrderBean.clear();
        repairOrderBean.addAll(data.getData().getOrderList());
        repairOrderAdapter.setNewData(repairOrderBean);

        if (page == 0) {
            repairOrderBean.clear();
            repairOrderBean.addAll(data.getData().getOrderList());
            repairOrderAdapter.setNewData(repairOrderBean);
            if (data.getData().getOrderList().size() > 0) {
                page += 1;
                repairOrderAdapter.setOnLoadMoreListener(RepairOrderRuningFragment.this, rvRepairOrderRuning);
            } else {
                repairOrderAdapter.loadMoreEnd();
            }
        } else {
            if (data.getData().getOrderList().size() > 0) {
                page += 1;
                repairOrderAdapter.addData(data.getData().getOrderList());
                repairOrderAdapter.loadMoreComplete();
            } else {
                repairOrderAdapter.loadMoreEnd();
            }
        }
        //空数据时的页面
        repairOrderAdapter.setEmptyView(R.layout.null_data, rvRepairOrderRuning);
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindUntilEvent(FragmentEvent.PAUSE);
    }

    @Override
    public void onLoadMoreRequested() {
        initData();
    }
}
