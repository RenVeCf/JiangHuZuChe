package com.ipd.jianghuzuche.activity;

import android.content.Intent;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.adapter.WalletAdapter;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.WalletDetailsBean;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.WalletDetailsContract;
import com.ipd.jianghuzuche.presenter.WalletDetailsPresenter;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.isClickUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.USER_ID;

/**
 * Description ：钱包
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/7.
 */
public class WalletActivity extends BaseActivity<WalletDetailsContract.View, WalletDetailsContract.Presenter> implements WalletDetailsContract.View, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.tv_wallet_top)
    TopView tvWalletTop;
    @BindView(R.id.tv_account_balance)
    TextView tvAccountBalance;
    @BindView(R.id.bt_cash_withdrawal)
    Button btCashWithdrawal;
    @BindView(R.id.srl_wallet)
    SwipeRefreshLayout srlWallet;
    @BindView(R.id.rv_wallet)
    RecyclerView rvWallet;

    private WalletAdapter walletAdapter;
    private List<WalletDetailsBean.DataBean.UserDetailedBean> userDetailedBean;
    private int page = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_wallet;
    }

    @Override
    public WalletDetailsContract.Presenter createPresenter() {
        return new WalletDetailsPresenter(this);
    }

    @Override
    public WalletDetailsContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        // 设置管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvWallet.setLayoutManager(layoutManager);
        // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rvWallet.setHasFixedSize(true);
        rvWallet.setItemAnimator(new DefaultItemAnimator());

        userDetailedBean = new ArrayList<>();
        walletAdapter = new WalletAdapter(userDetailedBean);
        rvWallet.setAdapter(walletAdapter);
    }

    @Override
    public void initListener() {
        srlWallet.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 0;
                initData();
                srlWallet.setRefreshing(false);
            }
        });
    }

    @Override
    public void initData() {
        TreeMap<String, String> walletDetailsMap = new TreeMap<>();
        walletDetailsMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
        walletDetailsMap.put("page", page + "");
        getPresenter().getWalletDetails(walletDetailsMap, true, false);
    }

    @OnClick(R.id.bt_cash_withdrawal)
    public void onViewClicked() {
        if (isClickUtil.isFastClick()) {

            startActivity(new Intent(this, CashWithdrawalActivity.class));
        }
    }

    @Override
    public void resultWalletDetails(WalletDetailsBean data) {
        tvAccountBalance.setText(data.getData().getUser().getBalance() + "");
        if (page == 0) {
            userDetailedBean.clear();
            userDetailedBean.addAll(data.getData().getUserDetailed());
            walletAdapter.setNewData(userDetailedBean);
            if (data.getData().getUserDetailed().size() > 0) {
                page += 1;
                walletAdapter.setOnLoadMoreListener(this, rvWallet);
            } else {
                walletAdapter.loadMoreEnd();
            }
        } else {
            if (data.getData().getUserDetailed().size() > 0) {
                page += 1;
                walletAdapter.addData(data.getData().getUserDetailed());
                walletAdapter.loadMoreComplete();
            } else {
                walletAdapter.loadMoreEnd();
            }
        }
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
