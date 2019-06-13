package com.ipd.jianghuzuche.activity;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.adapter.SelectBankTwoAdapter;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.SelectBankBean;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.SelectBankContract;
import com.ipd.jianghuzuche.presenter.SelectBankPresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.isClickUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.REQUEST_CODE_96;
import static com.ipd.jianghuzuche.common.config.IConstants.USER_ID;

public class SelectBankTwoActivity extends BaseActivity<SelectBankContract.View, SelectBankContract.Presenter> implements SelectBankContract.View, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.tv_select_bank_two_top)
    TopView tvSelectBankTwoTop;
    @BindView(R.id.rv_select_bank_two)
    RecyclerView rvSelectBankTwo;
    @BindView(R.id.bt_select_bank_two)
    Button btSelectBankTwo;
    @BindView(R.id.srl_select_bank_two)
    SwipeRefreshLayout srlSelectBankTwo;

    private SelectBankTwoAdapter selectBankAdapter;
    private List<SelectBankBean.DataBean.BankListBean> bankListBean;
    private int page = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_select_bank_two;
    }

    @Override
    public SelectBankContract.Presenter createPresenter() {
        return new SelectBankPresenter(this);
    }

    @Override
    public SelectBankContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvSelectBankTwoTop);

        // 设置管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvSelectBankTwo.setLayoutManager(layoutManager);
        // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rvSelectBankTwo.setHasFixedSize(true);
        rvSelectBankTwo.setItemAnimator(new DefaultItemAnimator());

        bankListBean = new ArrayList<>();
        selectBankAdapter = new SelectBankTwoAdapter(bankListBean);
        rvSelectBankTwo.setAdapter(selectBankAdapter);
    }

    @Override
    public void initListener() {
        srlSelectBankTwo.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 0;
                initData();
                srlSelectBankTwo.setRefreshing(false);
            }
        });
    }

    @Override
    public void initData() {
        TreeMap<String, String> selectBankMap = new TreeMap<>();
        selectBankMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
        selectBankMap.put("page", page + "");
        getPresenter().getSelectBank(selectBankMap, true, false);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (requestCode) {
                case REQUEST_CODE_96:
                    page = 0;
                    initData();
                    break;
            }
        }
    }

    @OnClick(R.id.bt_select_bank_two)
    public void onViewClicked() {
        if (isClickUtil.isFastClick()) {
            startActivityForResult(new Intent(this, AddBankAvtivity.class), REQUEST_CODE_96);
        }
    }

    @Override
    public void resultSelectBank(SelectBankBean data) {
        if (page == 0) {
            bankListBean.clear();
            bankListBean.addAll(data.getData().getBankList());
            selectBankAdapter.setNewData(bankListBean);
            if (data.getData().getBankList().size() > 0) {
                page += 1;
                selectBankAdapter.setOnLoadMoreListener(this, rvSelectBankTwo);
            } else {
                selectBankAdapter.loadMoreEnd();
            }
        } else {
            if (data.getData().getBankList().size() > 0) {
                page += 1;
                selectBankAdapter.addData(data.getData().getBankList());
                selectBankAdapter.loadMoreComplete();
            } else {
                selectBankAdapter.loadMoreEnd();
            }
        }
        selectBankAdapter.setEmptyView(R.layout.null_data, rvSelectBankTwo);
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
