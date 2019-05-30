package com.ipd.jianghuzuche.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.adapter.SelectBankAdapter;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.SelectBankBean;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.SelectBankContract;
import com.ipd.jianghuzuche.presenter.SelectBankPresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.SPUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import butterknife.OnClick;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.REQUEST_CODE_94;
import static com.ipd.jianghuzuche.common.config.IConstants.USER_ID;

/**
 * Description ：选择银行卡
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/5/14.
 */
public class SelectBankActivity extends BaseActivity<SelectBankContract.View, SelectBankContract.Presenter> implements SelectBankContract.View, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.tv_select_bank_top)
    TopView tvSelectBankTop;
    @BindView(R.id.rv_select_bank)
    RecyclerView rvSelectBank;
    @BindView(R.id.bt_select_bank)
    Button btSelectBank;
    @BindView(R.id.srl_select_bank)
    SwipeRefreshLayout srlSelectBank;

    private SelectBankAdapter selectBankAdapter;
    private List<SelectBankBean.DataBean.BankListBean> bankListBean;
    private static Handler handler = new Handler();
    private int page = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_select_bank;
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
        ImmersionBar.setTitleBar(this, tvSelectBankTop);

        // 设置管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvSelectBank.setLayoutManager(layoutManager);
        // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rvSelectBank.setHasFixedSize(true);
        rvSelectBank.setItemAnimator(new DefaultItemAnimator());

        bankListBean = new ArrayList<>();
        selectBankAdapter = new SelectBankAdapter(bankListBean);
        rvSelectBank.setAdapter(selectBankAdapter);
    }

    @Override
    public void initListener() {
        srlSelectBank.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 0;
                initData();
                srlSelectBank.setRefreshing(false);
            }
        });

        selectBankAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, final int position) {
                for (int i = 0; i < bankListBean.size(); i++) {
                    bankListBean.get(i).setStatus(2);
                }
                bankListBean.get(position).setStatus(1);
                selectBankAdapter.notifyDataSetChanged();

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // 使用postDelayed方式修改UI组件tvMessage的Text属性值
                        // 并且延迟3S执行
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                setResult(RESULT_OK, new Intent().putExtra("bankListBean", bankListBean.get(position)));
                                finish();
                            }
                        }, 1000);
                    }
                }).start();
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
                case REQUEST_CODE_94:
                    page = 0;
                    initData();
                    break;
            }
        }
    }

    @OnClick(R.id.bt_select_bank)
    public void onViewClicked() {
        startActivityForResult(new Intent(this, AddBankAvtivity.class), REQUEST_CODE_94);
    }

    @Override
    public void resultSelectBank(SelectBankBean data) {
        if (page == 0) {
            bankListBean.clear();
            bankListBean.addAll(data.getData().getBankList());
            selectBankAdapter.setNewData(bankListBean);
            if (data.getData().getBankList().size() > 0) {
                page += 1;
                selectBankAdapter.setOnLoadMoreListener(this, rvSelectBank);
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
        selectBankAdapter.setEmptyView(R.layout.null_data, rvSelectBank);
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
