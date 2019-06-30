package com.ipd.jianghuzuche.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ipd.jianghuzuche.R;
import com.ipd.jianghuzuche.activity.ExtendTimeActivity;
import com.ipd.jianghuzuche.activity.OrderDetailsActivity;
import com.ipd.jianghuzuche.activity.ReturnCarActivity;
import com.ipd.jianghuzuche.activity.SelectCarActivity;
import com.ipd.jianghuzuche.activity.SelectPayTypeActivity;
import com.ipd.jianghuzuche.activity.SelectReturnCarActivity;
import com.ipd.jianghuzuche.adapter.OrderTypeAdapter;
import com.ipd.jianghuzuche.base.BaseFragment;
import com.ipd.jianghuzuche.bean.CancelOrderBean;
import com.ipd.jianghuzuche.bean.SelectOrderTypeBean;
import com.ipd.jianghuzuche.contract.SelectOrderTypeContract;
import com.ipd.jianghuzuche.presenter.SelectOrderTypePresenter;
import com.ipd.jianghuzuche.utils.LogUtils;
import com.ipd.jianghuzuche.utils.SPUtil;
import com.ipd.jianghuzuche.utils.ToastUtil;
import com.ipd.jianghuzuche.utils.isClickUtil;
import com.trello.rxlifecycle2.android.FragmentEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import butterknife.BindView;
import io.reactivex.ObservableTransformer;

import static com.ipd.jianghuzuche.common.config.IConstants.REQUEST_CODE_92;
import static com.ipd.jianghuzuche.common.config.IConstants.USER_ID;

/**
 * Description ：订单查看
 * Author ： rmy
 * Email ： 942685687@qq.com
 * Time ： 2019/4/29.
 */
public class AllOrderTypeFragment extends BaseFragment<SelectOrderTypeContract.View, SelectOrderTypeContract.Presenter> implements SelectOrderTypeContract.View, BaseQuickAdapter.RequestLoadMoreListener {
    @BindView(R.id.rv_order_type)
    RecyclerView rvOrderType;
    @BindView(R.id.srl_order_type)
    SwipeRefreshLayout srlOrderType;

    private List<SelectOrderTypeBean.DataBean.OrderListBean> selectOrderTypeBean;
    private OrderTypeAdapter orderTypeAdapter;
    private int fmType;
    private int page = 0;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_order_type;
    }

    @Override
    public SelectOrderTypeContract.Presenter createPresenter() {
        return new SelectOrderTypePresenter(mContext);
    }

    @Override
    public SelectOrderTypeContract.View createView() {
        return this;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        ToastUtil.showShortToast("11111111111111111111");
    }

    @Override
    public void init(View view) {
        Bundle args = getArguments();
        if (args != null) {
            fmType = args.getInt("fm_type");
        }

        // 设置管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvOrderType.setLayoutManager(layoutManager);
        // 如果可以确定每个item的高度是固定的，设置这个选项可以提高性能
        rvOrderType.setHasFixedSize(true);
        rvOrderType.setItemAnimator(new DefaultItemAnimator());

        selectOrderTypeBean = new ArrayList<>();
        orderTypeAdapter = new OrderTypeAdapter(selectOrderTypeBean, fmType);
        rvOrderType.setAdapter(orderTypeAdapter);
    }

    @Override
    public void initListener() {
        srlOrderType.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 0;
                initData();
                srlOrderType.setRefreshing(false);
            }
        });

        orderTypeAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                if (isClickUtil.isFastClick()) {
                    switch (selectOrderTypeBean.get(position).getStatus()) {
                        case 2:
                            //已取消
                            startActivity(new Intent(getContext(), OrderDetailsActivity.class).putExtra("type", 6).putExtra("order_id", selectOrderTypeBean.get(position).getOrderId()));
                            break;
                        case 3:
                            //待付款
                            startActivityForResult(new Intent(getContext(), OrderDetailsActivity.class).putExtra("type", 1).putExtra("order_id", selectOrderTypeBean.get(position).getOrderId()), REQUEST_CODE_92);
                            break;
                        case 4:
                            //待取车
                            startActivityForResult(new Intent(getContext(), OrderDetailsActivity.class).putExtra("type", 2).putExtra("order_id", selectOrderTypeBean.get(position).getOrderId()), REQUEST_CODE_92);
                            break;
                        case 5:
                            //使用中
                            startActivityForResult(new Intent(getContext(), OrderDetailsActivity.class).putExtra("type", 3).putExtra("order_id", selectOrderTypeBean.get(position).getOrderId()).putExtra("take_status", selectOrderTypeBean.get(position).getTakeStatus()).putExtra("item_type", 1), REQUEST_CODE_92);
                            break;
                        case 7:
                            //已到期
                            startActivityForResult(new Intent(getContext(), OrderDetailsActivity.class).putExtra("type", 4).putExtra("order_id", selectOrderTypeBean.get(position).getOrderId()).putExtra("take_status", selectOrderTypeBean.get(position).getTakeStatus()), REQUEST_CODE_92);
                            break;
                        case 8:
                            //已完成
                            startActivity(new Intent(getContext(), OrderDetailsActivity.class).putExtra("type", 5).putExtra("order_id", selectOrderTypeBean.get(position).getOrderId()));
                            break;
                    }
                }
            }
        });

        orderTypeAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
                if (isClickUtil.isFastClick()) {
                    switch (view.getId()) {
                        case R.id.bt_order_type_start:
                            switch (selectOrderTypeBean.get(position).getStatus()) {
                                case 3:
                                    setDocumentsReceivedDialog(0, selectOrderTypeBean.get(position).getOrderId(), position);
                                    break;
                                case 4:
                                    setDocumentsReceivedDialog(1, selectOrderTypeBean.get(position).getOrderId(), position);
                                    break;
                                case 5:
                                    startActivity(new Intent(getActivity(), ExtendTimeActivity.class).putExtra("order_id", selectOrderTypeBean.get(position).getOrderId()));
                                    break;
                                case 7:
                                    startActivity(new Intent(getActivity(), ExtendTimeActivity.class).putExtra("order_id", selectOrderTypeBean.get(position).getOrderId()));
                                    break;
                            }
                            break;
                        case R.id.bt_order_type_end:
                            switch (selectOrderTypeBean.get(position).getStatus()) {
                                case 3:
                                    startActivity(new Intent(getActivity(), SelectPayTypeActivity.class).putExtra("order_id", selectOrderTypeBean.get(position).getOrderId()));
                                    break;
                                case 4:
                                    startActivityForResult(new Intent(getActivity(), SelectCarActivity.class).putExtra("order_id", selectOrderTypeBean.get(position).getOrderId()), REQUEST_CODE_92);
                                    break;
                                case 5:
                                    switch (selectOrderTypeBean.get(position).getTakeStatus()) {
                                        case 1:
                                            //提前还车
                                            setDocumentsReceivedDialog(2, selectOrderTypeBean.get(position).getOrderId(), position);
                                            break;
                                        case 2:
                                            startActivityForResult(new Intent(getActivity(), SelectReturnCarActivity.class).putExtra("order_id", selectOrderTypeBean.get(position).getOrderId()).putExtra("take_status", selectOrderTypeBean.get(position).getTakeStatus()).putExtra("type", 3), REQUEST_CODE_92);
                                    }
                                    break;
                                case 7:
                                    switch (selectOrderTypeBean.get(position).getTakeStatus()) {
                                        case 1:
                                            //申请退车
                                            setDocumentsReceivedDialog(3, selectOrderTypeBean.get(position).getOrderId(), position);
                                            break;
                                        case 2:
                                            startActivityForResult(new Intent(getActivity(), SelectReturnCarActivity.class).putExtra("order_id", selectOrderTypeBean.get(position).getOrderId()).putExtra("take_status", selectOrderTypeBean.get(position).getTakeStatus()).putExtra("type", 4), REQUEST_CODE_92);
                                    }
                                    break;
                            }
                            break;
                    }
                }
            }
        });
    }

    @Override
    public void initData() {
        String status = "";
        switch (fmType) {
            case 0:
                status = "1";
                break;
            case 1:
                status = "3";
                break;
            case 2:
                status = "4";
                break;
            case 3:
                status = "5";
                break;
            case 4:
                status = "7";
                break;
            case 5:
                status = "8";
                break;
            case 6:
                status = "2";
                break;
        }
        TreeMap<String, String> loginMap = new TreeMap<>();
        loginMap.put("userId", SPUtil.get(getActivity(), USER_ID, "") + "");
        loginMap.put("status", status);
        loginMap.put("page", page + "");
        getPresenter().getSelectOrderType(loginMap, false, false);
    }

    public void Aaa(int position) {
        fmType = position;
        page = 0;
        initData();
        orderTypeAdapter.notifyDataSetChanged();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            switch (requestCode) {
                case REQUEST_CODE_92:
                    page = 0;
                    initData();
                    orderTypeAdapter.notifyDataSetChanged();
                    break;
            }
        }
    }

    private void setDocumentsReceivedDialog(final int type, final int orderId, final int position) {
        final TextView tv;
        final Dialog mCameraDialog = new Dialog(getContext(), R.style.BottomDialog);
        //Dialog布局
        LinearLayout root = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.dialog_center, null);
        tv = root.findViewById(R.id.tv_dialog_center_end);
        switch (type) {
            case 0:
                tv.setText("是否取消订单？");
                break;
            case 1:
                tv.setText("是否取消订单？");
                break;
            case 2:
                tv.setText("是否提前还车？");
                break;
            case 3:
                tv.setText("是否申请退车？");
                break;
        }

        //初始化视图
        root.findViewById(R.id.dialog_center_confirm).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (type) {
                    case 0:
                        TreeMap<String, String> unpaidCancelOrderMap = new TreeMap<>();
                        unpaidCancelOrderMap.put("userId", SPUtil.get(getActivity(), USER_ID, "") + "");
                        unpaidCancelOrderMap.put("orderId", orderId + "");
                        getPresenter().getUnpaidCancelOrder(unpaidCancelOrderMap, true, false);
                        break;
                    case 1:
                        TreeMap<String, String> getCarCancelOrderMap = new TreeMap<>();
                        getCarCancelOrderMap.put("userId", SPUtil.get(getActivity(), USER_ID, "") + "");
                        getCarCancelOrderMap.put("orderId", orderId + "");
                        getPresenter().getGetCarCancelOrder(getCarCancelOrderMap, true, false);
                        break;
                    case 2:
                        startActivityForResult(new Intent(getActivity(), ReturnCarActivity.class).putExtra("return_car_title", "提前还车").putExtra("store_name", selectOrderTypeBean.get(position).getStoreName()).putExtra("order_id", orderId), REQUEST_CODE_92);
                        break;
                    case 3:
                        startActivityForResult(new Intent(getActivity(), ReturnCarActivity.class).putExtra("return_car_title", "申请还车").putExtra("store_name", selectOrderTypeBean.get(position).getStoreName()).putExtra("order_id", orderId), REQUEST_CODE_92);
                        break;
                }
                mCameraDialog.dismiss();
            }
        });

        root.findViewById(R.id.dialog_center_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCameraDialog.dismiss();
            }
        });
        mCameraDialog.setContentView(root);
        Window dialogWindow = mCameraDialog.getWindow();
        dialogWindow.setGravity(Gravity.CENTER); //设置弹出方式
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = 0; // 新位置Y坐标
        lp.width = 700;
        root.measure(0, 0);
        lp.height = 320;

        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
        mCameraDialog.show();
    }

    @Override
    public void resultSelectOrderType(SelectOrderTypeBean data) {
        if (page == 0) {
            selectOrderTypeBean.clear();
            selectOrderTypeBean.addAll(data.getData().getOrderList());
            orderTypeAdapter.setNewData(selectOrderTypeBean);
            if (data.getData().getOrderList().size() > 0) {
                page += 1;
                orderTypeAdapter.setOnLoadMoreListener(AllOrderTypeFragment.this, rvOrderType);
            } else {
                orderTypeAdapter.loadMoreEnd();
            }
        } else {
            if (data.getData().getOrderList().size() > 0) {
                page += 1;
                orderTypeAdapter.addData(data.getData().getOrderList());
                orderTypeAdapter.loadMoreComplete();
            } else {
                orderTypeAdapter.loadMoreEnd();
            }
        }
        //空数据时的页面
        orderTypeAdapter.setEmptyView(R.layout.null_data, rvOrderType);
    }

    @Override
    public void resultUnpaidCancelOrder(CancelOrderBean data) {
        ToastUtil.showLongToast(data.getMsg());
        if (data.getCode() == 200) {
            page = 0;
            initData();
            orderTypeAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void resultGetCarCancelOrder(CancelOrderBean data) {
        ToastUtil.showLongToast(data.getMsg());
        if (data.getCode() == 200) {
            page = 0;
            initData();
            orderTypeAdapter.notifyDataSetChanged();
        }
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
