package com.ipd.jianghuzuche.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.activity.MainActivity;
import com.ipd.jianghuzuche.activity.StoreDetailsActivity;
import com.ipd.jianghuzuche.activity.WebViewActivity;
import com.ipd.jianghuzuche.adapter.RepairAdapter;
import com.ipd.jianghuzuche.base.BaseFragment;
import com.ipd.jianghuzuche.bean.ChoiceStoreBean;
import com.ipd.jianghuzuche.bean.RepairListBean;
import com.ipd.jianghuzuche.contract.RepairListContract;
import com.ipd.jianghuzuche.presenter.RepairListPresenter;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.ToastUtil;
import com.ipd.jianghuzuche.utils.isClickUtil;
import com.ryane.banner.AdPageInfo;
import com.ryane.banner.AdPlayBanner;
import com.trello.rxlifecycle2.android.FragmentEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.LATIUDE;
import static com.ipd.jianghuzuche.common.config.IConstants.LONGTITUDE;
import static com.ipd.jianghuzuche.common.config.UrlConfig.BASE_LOCAL_URL;
import static com.ryane.banner.AdPlayBanner.ImageLoaderType.GLIDE;

/**
 * Description ：维修保养
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/4/29.
 */
public class RepairFragment extends BaseFragment<RepairListContract.View, RepairListContract.Presenter> implements RepairListContract.View {

    @BindView(R.id.rv_repair)
    RecyclerView rvRepair;
    @BindView(R.id.srl_repair)
    SwipeRefreshLayout srlRepair;
    @BindView(R.id.ab_repair)
    AdPlayBanner abRepair;

    private List<AdPageInfo> images = new ArrayList<>();
    private List<RepairListBean.DataBean.StoreListBean> repairListBean = new ArrayList<>();
    private RepairAdapter repairAdapter;
    private int pageNum = 0;//页数

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.tvTopTitle.setText(this.getResources().getString(R.string.repair));
        mainActivity.tvTopTitle.setTextColor(Color.BLACK);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_repair;
    }

    @Override
    public RepairListContract.Presenter createPresenter() {
        return new RepairListPresenter(mContext);
    }

    @Override
    public RepairListContract.View createView() {
        return this;
    }

    @Override
    public void init(View view) {
        MainActivity mainActivity = (MainActivity) getActivity();
        mainActivity.tvTopTitle.setText(this.getResources().getString(R.string.repair));
        mainActivity.tvTopTitle.setTextColor(Color.BLACK);

        // 设置管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvRepair.setLayoutManager(layoutManager);
        // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rvRepair.setHasFixedSize(true);
        rvRepair.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void initListener() {
        srlRepair.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                pageNum = 0;
                initData();
                srlRepair.setRefreshing(false);
            }
        });
    }

    @Override
    public void initData() {
        TreeMap<String, String> repairListMap = new TreeMap<>();
        repairListMap.put("longitude", SPUtil.get(getActivity(), LONGTITUDE, "") + "");
        repairListMap.put("latitude", SPUtil.get(getActivity(), LATIUDE, "") + "");
        repairListMap.put("page", pageNum + "");
        getPresenter().getRepairList(repairListMap, true, false);
    }

    @Override
    public void resultRepairList(final RepairListBean data) {
        if (data.getCode() == 200) {
            if (data.getData().getStoreList().size() > 0) {
                if (pageNum == 0) {
                    repairListBean.clear();
                    repairListBean.addAll(data.getData().getStoreList());
                    repairAdapter = new RepairAdapter(repairListBean);
                    rvRepair.setAdapter(repairAdapter);
                    repairAdapter.bindToRecyclerView(rvRepair);
                    repairAdapter.setEnableLoadMore(true);
                    repairAdapter.openLoadAnimation();
                    repairAdapter.disableLoadMoreIfNotFullPage();

                    repairAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
                        @Override
                        public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                            if (isClickUtil.isFastClick()) {
                                ChoiceStoreBean.DataBean.StoreListBean choiceStoreBeanList = new ChoiceStoreBean.DataBean.StoreListBean();
                                choiceStoreBeanList.setStoreId(repairListBean.get(position).getStoreId());
                                choiceStoreBeanList.setStoreName(repairListBean.get(position).getStoreName());
                                choiceStoreBeanList.setDescAddress(repairListBean.get(position).getDescAddress());
                                choiceStoreBeanList.setDistance(repairListBean.get(position).getDistance());
                                choiceStoreBeanList.setContactsPhone(repairListBean.get(position).getContactsPhone());
                                choiceStoreBeanList.setPicPath(repairListBean.get(position).getPicPath());
                                choiceStoreBeanList.setLongitude(repairListBean.get(position).getLongitude());
                                choiceStoreBeanList.setLatitude(repairListBean.get(position).getLatitude());
                                startActivity(new Intent(getActivity(), StoreDetailsActivity.class).putExtra("store_details", choiceStoreBeanList).putExtra("store_type", 1));
                            }
                        }
                    });

                    //上拉加载
                    repairAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
                        @Override
                        public void onLoadMoreRequested() {
                            rvRepair.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    initData();
                                }
                            }, 1000);
                        }
                    }, rvRepair);

                    if (repairListBean.size() >= 10) {
                        pageNum += 1;
                    } else {
                        repairAdapter.loadMoreEnd();
                    }
                } else {
                    if ((data.getData().getStoreList().size() - pageNum * 10) >= 0) {
                        pageNum += 1;
                        repairAdapter.addData(data.getData().getStoreList());
                        repairAdapter.loadMoreComplete(); //完成本次
                    } else {
                        repairAdapter.addData(data.getData().getStoreList());
                        repairAdapter.loadMoreEnd(); //完成所有加载
                    }
                }
            } else {
                repairListBean.clear();
                repairAdapter = new RepairAdapter(repairListBean);
                rvRepair.setAdapter(repairAdapter);
                repairAdapter.loadMoreEnd(); //完成所有加载
                repairAdapter.setEmptyView(R.layout.null_data, rvRepair);
            }
        } else
            ToastUtil.showLongToast(data.getMsg());


        AdPageInfo info1;
        for (int i = 0; i < data.getData().getPictureList().size(); i++) {
            if (data.getData().getPictureList().get(i).getType() == 2)
                info1 = new AdPageInfo("", BASE_LOCAL_URL + data.getData().getPictureList().get(i).getPicPath(), data.getData().getPictureList().get(i).getContent(), i + 1);
            else
                info1 = new AdPageInfo("", BASE_LOCAL_URL + data.getData().getPictureList().get(i).getPicPath(), "", i + 1);
            images.add(info1);
        }
        abRepair.setInfoList(images)
                .setImageLoadType(GLIDE)
                .setOnPageClickListener(new AdPlayBanner.OnPageClickListener() {
                    @Override
                    public void onPageClick(AdPageInfo info, int postion) {
                        if (data.getData().getPictureList().get(postion).getType() == 3)
                            startActivity(new Intent(getActivity(), WebViewActivity.class).putExtra("h5Type", 8).putExtra("url", data.getData().getPictureList().get(postion).getContent()));
                    }
                })
                .setUp();
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindUntilEvent(FragmentEvent.PAUSE);
    }
}
