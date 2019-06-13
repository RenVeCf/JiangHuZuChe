package com.ipd.jianghuzuche.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.adapter.UserSelectCarAdapter;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.UserSelectCarBean;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.UserSelectCarContract;
import com.ipd.jianghuzuche.presenter.UserSelectCarPresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.isClickUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import io.reactivex.ObservableTransformer;

/**
 * Description ：选车
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/4/30.
 */
public class UserSelectCarActivity extends BaseActivity<UserSelectCarContract.View, UserSelectCarContract.Presenter> implements UserSelectCarContract.View, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.tv_user_select_car_top)
    TopView tvUserSelectCarTop;
    @BindView(R.id.rv_user_select_car)
    RecyclerView rvUserSelectCar;
    @BindView(R.id.srl_user_select_car)
    SwipeRefreshLayout srlUserSelectCar;

    private List<UserSelectCarBean.DataBean.VehicleListBean> userSelectCarBean;
    private UserSelectCarBean.DataBean.StoreByIdBean storeByIdBean = new UserSelectCarBean.DataBean.StoreByIdBean();
    private UserSelectCarAdapter userSelectCarAdapter;
    private String storeId = "";
    private int page = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_user_select_car;
    }

    @Override
    public UserSelectCarContract.Presenter createPresenter() {
        return new UserSelectCarPresenter(this);
    }

    @Override
    public UserSelectCarContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvUserSelectCarTop);

        // 设置管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvUserSelectCar.setLayoutManager(layoutManager);
        // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rvUserSelectCar.setHasFixedSize(true);
        rvUserSelectCar.setItemAnimator(new DefaultItemAnimator());

        storeId = getIntent().getStringExtra("storeId");

        userSelectCarBean = new ArrayList<>();
        userSelectCarAdapter = new UserSelectCarAdapter(userSelectCarBean);
        rvUserSelectCar.setAdapter(userSelectCarAdapter);
    }

    @Override
    public void initListener() {
        srlUserSelectCar.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 0;
                initData();
                srlUserSelectCar.setRefreshing(false);
            }
        });

        userSelectCarAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (isClickUtil.isFastClick()) {

                    startActivity(new Intent(UserSelectCarActivity.this, CarDetailsActivity.class).putExtra("car_details", userSelectCarBean.get(position)).putExtra("store_by_id", storeByIdBean));
                }
            }
        });
    }

    @Override
    public void initData() {
        if (!storeId.equals("")) {
            TreeMap<String, String> choiceStoreMap = new TreeMap<>();
            choiceStoreMap.put("storeId", storeId);
            choiceStoreMap.put("page", page + "");
            getPresenter().getUserSelectCar(choiceStoreMap, false, false);
        }
    }

    @Override
    public void resultUserSelectCar(UserSelectCarBean data) {
        if (page == 0) {
            storeByIdBean = data.getData().getStoreById();
            userSelectCarBean.clear();
            userSelectCarBean.addAll(data.getData().getVehicleList());
            userSelectCarAdapter.setNewData(userSelectCarBean);
            if (data.getData().getVehicleList().size() > 0) {
                page += 1;
                userSelectCarAdapter.setOnLoadMoreListener(this, rvUserSelectCar);
            } else {
                userSelectCarAdapter.loadMoreEnd();
            }
        } else {
            if (data.getData().getVehicleList().size() > 0) {
                page += 1;
                userSelectCarAdapter.addData(data.getData().getVehicleList());
                userSelectCarAdapter.loadMoreComplete();
            } else {
                userSelectCarAdapter.loadMoreEnd();
            }
        }
        //空数据时的页面
        userSelectCarAdapter.setEmptyView(R.layout.null_data, rvUserSelectCar);
    }

    @Override
    public <T> ObservableTransformer<T, T> bindLifecycle() {
        return this.bindToLifecycle();
    }

    @Override
    public void onLoadMoreRequested() {
        initData();
    }
}
