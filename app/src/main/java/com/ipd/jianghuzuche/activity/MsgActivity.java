package com.ipd.jianghuzuche.activity;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.gyf.barlibrary.ImmersionBar;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.adapter.MsgAdapter;
import com.ipd.jianghuzuche.base.BaseActivity;
import com.ipd.jianghuzuche.bean.MsgBean;
import com.ipd.jianghuzuche.common.view.TopView;
import com.ipd.jianghuzuche.contract.MsgContract;
import com.ipd.jianghuzuche.presenter.MsgPresenter;
import com.ipd.jianghuzuche.utils.ApplicationUtil;
import com.ipd.jianghuzuche.utils.SPUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.USER_ID;

public class MsgActivity extends BaseActivity<MsgContract.View, MsgContract.Presenter> implements MsgContract.View, BaseQuickAdapter.RequestLoadMoreListener {

    @BindView(R.id.tv_msg_top)
    TopView tvMsgTop;
    @BindView(R.id.rv_msg)
    RecyclerView rvMsg;
    @BindView(R.id.srl_msg)
    SwipeRefreshLayout srlMsg;

    private MsgAdapter msgAdapter;
    private List<MsgBean.DataBean.MessageListBean> messageListBean;
    private int page = 0;

    @Override
    public int getLayoutId() {
        return R.layout.activity_msg;
    }

    @Override
    public MsgContract.Presenter createPresenter() {
        return new MsgPresenter(this);
    }

    @Override
    public MsgContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        //将每个Activity加入到栈中
        ApplicationUtil.getManager().addActivity(this);
        //防止状态栏和标题重叠
        ImmersionBar.setTitleBar(this, tvMsgTop);

        // 设置管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvMsg.setLayoutManager(layoutManager);
        // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rvMsg.setHasFixedSize(true);
        rvMsg.setItemAnimator(new DefaultItemAnimator());

        messageListBean = new ArrayList<>();
        msgAdapter = new MsgAdapter(messageListBean);
        rvMsg.setAdapter(msgAdapter);
    }

    @Override
    public void initListener() {
        srlMsg.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 0;
                initData();
                srlMsg.setRefreshing(false);
            }
        });
    }

    @Override
    public void initData() {
        TreeMap<String, String> msgMap = new TreeMap<>();
        msgMap.put("userId", SPUtil.get(this, USER_ID, "") + "");
        msgMap.put("page", page + "");
        getPresenter().getMsg(msgMap, true, false);
    }

    @Override
    public void resultMsg(MsgBean data) {
        if (page == 0) {
            messageListBean.clear();
            messageListBean.addAll(data.getData().getMessageList());
            msgAdapter.setNewData(messageListBean);
            if (data.getData().getMessageList().size() > 0) {
                page += 1;
                msgAdapter.setOnLoadMoreListener(this, rvMsg);
            } else {
                msgAdapter.loadMoreEnd();
            }
        } else {
            if (data.getData().getMessageList().size() > 0) {
                page += 1;
                msgAdapter.addData(data.getData().getMessageList());
                msgAdapter.loadMoreComplete();
            } else {
                msgAdapter.loadMoreEnd();
            }
        }
        //空数据时的页面
        msgAdapter.setEmptyView(R.layout.null_data, rvMsg);
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
